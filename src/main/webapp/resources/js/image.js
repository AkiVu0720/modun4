$(document).ready(function () {
    $("#modal-submit").click(function (){
        window.location ="http://localhost:8080/image/initCreate"
    })
    $("#direction").change(function (){
        let direction = $("#direction").val()
        window.location="http://localhost:8080/image/findImage?direction="+direction
    })

    $("#sortBy").change(function (){
        let sortBy = $("#sortBy").val();
        window.location="http://localhost:8080/image/findImage?sortBy="+sortBy
    })
    $("#modal-create").click(function (){
        window.location ="http://localhost:8080/image/initCreate"
    })
    $("#modal-close").click(function (){
        window.location ="http://localhost:8080/image/findImage"
    })
})