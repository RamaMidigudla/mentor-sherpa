/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function() {
    //attach autocomplete
    $("#tagQuery").autocomplete({
        minLength: 1,
        delay: 500,
        //define callback to format results
        source: function (request, response) {
            $.getJSON("${contextPath}/organization/auto", request, function(result) {
                response($.map(result, function(item) {
                    return {
                        // following property gets displayed in drop down
                        label: item.name,
                        // following property gets entered in the textbox
                        value: item.name,
                        
                        tag_url: ctx + "/organization/viewProfile/" + item.objectId
                       
                    }
                }));
            });
        },
                 select: function( event, ui ) {
                     
        window.location.href = ui.item.tag_url;
    }
    }); 
});


