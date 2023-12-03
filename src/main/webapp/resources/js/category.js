$(document).ready(function (){
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