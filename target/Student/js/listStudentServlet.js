function getData() {
    let userName = $("#userNmae").val();
        $.ajax({
            url: "/listStudentServlet",
            type: "post",
            dataType: "json",
            data: {
                "submit": "确定",
                "userName": userName
            },
            success: function (res) {
                //console.log(res);
                //JSON.parse(res);
                showResponseData(res);
            },
            error: function () {
                alert("失败");
            }
        });
}

function showResponseData(data){
    //let studentList=JSON.parse(data);
    let studentList=data;
    if(studentList.length==0)
        return 1;
    for(s of studentList){
        //console.log(s.stuNo+" "+s.stuName);
        var tr="<tr>";
        for(i in s){
            if(i!="photoPath"){
                tr+="<td>"+s[i]+"</td>";
            }else{
                tr+="<td><img src='"+s[i]+"'>"+"</td>";
            }
        }
        tr+="<td><a href='/jsp/addstudent.jsp?stuno="+s["stuNo"]+"'>增加</a>&nbsp<a href='/jsp/deletestudent.jsp?stuno="+
            s["stuNo"]+"'>删除</a>&nbsp" +
            "<a href='/jsp/updatestudent.jsp?stuno="+s["stuNo"]+"'>修改</a></td>";
        tr+="</tr>";
        $("#students tr:last").after(tr);
    }
}


