/**
 * 搜索框联想
 */
function searchKey() {
    var input_text = document.getElementById("input_text");  // 获取对象
    input_text = input_text.value;  // 获取对象的值
    // alert(input_text);

    var txt = "";
    // 调用后端的接口
    $.ajax({
        type: "GET",
        url: "searchKey",
        data: {"value": input_text},
        dataType: "json",
        // 调用接口后, 传来的数据赋值给 data
        success: function (data) {
            $('li').remove();
            $('h3').remove();
            for (i in data) {  // 注意: 此处i为字典的键
                // alert(data[i])
                txt = '<li style=" list-style: none; width: 200px; text-align:left;">' + data[i] + '</li>';
                $('#ul').append(txt); // 将txt添加到ul中
                //点击查询结果写入input
                $('#ul li').eq(i).click(function () {
                    $('#input_text').val($(this).text());//写入input
                    $('li').remove();//添加完成关闭 li
                    $('h3').remove();//添加完成关闭 li
                });
            }
            <!-- 注意此处将 拼接完成的html元素 重整至 html页面 -->
            // $("#ul").html(txt);  // 用txt覆盖掉ul中的内容
        }
    })
}

/**
 * 每日推荐
 */
function suggest() {

    var input_text = document.getElementById("input_text");  // 获取对象
    input_text = input_text.value;  // 获取对象的值
    // 获取焦点且 input框中的值为 ""
    if (input_text === "") {
        var txt = "";
        // 调用后端的接口
        $.ajax({
            type: "GET",
            url: "suggest",
            dataType: "json",
            // 调用接口后, 传来的数据赋值给 data
            success: function (data) {
                $('li').remove();
                $('h3').remove();
                txt = '<h3 style=" text-align:left;">大家都在搜</h3>';
                $('#ul').append(txt);
                for (i in data) {  // 注意: 此处i为字典的键
                    // alert(data[i])
                    txt = '<li style=" list-style: none; width: 200px; text-align:left;">' + data[i] + '</li>';
                    $('#ul').append(txt); // 将txt添加到ul中
                    //点击查询结果写入input
                    $('#ul li').eq(i).click(function () {
                        $('#input_text').val($(this).text());//写入input
                        $('li').remove();//添加完成关闭 li
                        $('h3').remove();//添加完成关闭 li
                    });
                }
                <!-- 注意此处将 拼接完成的html元素 重整至 html页面 -->
                // $("#ul").html(txt);  // 用txt覆盖掉ul中的内容
            }
        })
    }
}