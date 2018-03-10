function initcontrol(control,data){
     for(var field in data){
         if(control.find(field).html()!=undefined)
         {
             control.find(field).html(data[filed]);
         }
     }
}