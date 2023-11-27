$(document).ready(function () {
    $("#modal-submit").click(function (){
        window.location ="http://localhost:8080/product/initCreate"
    })
    $("#direction").change(function (){
        let direction = $("#direction").val()
        window.location="http://localhost:8080/product/findProduct?direction="+direction
    })

    $("#sortBy").change(function (){
        let sortBy = $("#sortBy").val();
        window.location="http://localhost:8080/product/findProduct?sortBy="+sortBy
    })
    $("#modal-create").click(function (){
        window.location ="http://localhost:8080/product/initCreate"
    })
    $("#modal-close").click(function (){
        window.location ="http://localhost:8080/product/findProduct"
    })
})