$(document).ready(function (){
    $(".page-category").click(function () {
        let pageId = $(this).attr("pageId")
        let This = $(this)
        console.log("<%=request.getContextPath()%>/category/findCategory?page="+pageId);
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/category/findCategory"
            // data: { name: "John", location: "Boston" }
        }).done(function() {
            // window.location = "http://localhost:8080/category/findCategory?page="+pageId
        });
    });

    $("#direction").change(function (){
        let direction = $("#direction").val()
        window.location="http://localhost:8080/category/findCategory?direction="+direction
    })

    $("#sortBy").change(function (){
        let sortBy = $("#sortBy").val();
        window.location="http://localhost:8080/category/findCategory?sortBy="+sortBy
    })
    $("#modal-create").click(function (){
        window.location ="http://localhost:8080/category/initCreate"
    })
    $("#modal-close").click(function (){
        window.location ="http://localhost:8080/category/findCategory"
    })
    $("#modal-submit").click(function (){
        window.location ="http://localhost:8080/category/create"
    })

})