<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
    <title>Simple Map</title>
    <meta name="viewport" content="initial-scale=1.0">
    <meta charset="utf-8">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
      #map {
        height: 100%;
      }
      #loading-image{
       width:100%;
       margin:0 auto;
       background-image: url("img/loading.png");
      }
    </style>

  </head>
  <body>
  <div id="#loading-image"></div>
    <div id="map"></div>
    <div class="container">
  
  <!-- Trigger the modal with a button -->
  <!-- <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal</button> -->

  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Tweets</h4>
        </div>
        <div class="modal-body">
          <!-- content  -->
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
  
</div>
    <script>
      var map;
      function initMap() {
        map = new google.maps.Map(document.getElementById('map'), {
          center: {lat: 40, lng: -4},
          zoom: 8
        });

       //This runs when the user clicks on the map
    google.maps.event.addListener(map, 'click', function(event)
    {
      //initialize geocoder
      var geocoder = new google.maps.Geocoder()

     

      //prepare latitude and longitude
      var latlng = new google.maps.LatLng(event.latLng.lat(), event.latLng.lng());

      //get address info such as city and state from lat and long
      geocoder.geocode({'latLng': latlng}, function(results, status) 
      {
        if (status == google.maps.GeocoderStatus.OK) 
        {

          var arrAddress = results[0].address_components;
        //  console.log(arrAddress[1].long_name);
// iterate through address_component array
   //find country name
   var country='';
   var flag=false;
        for (var i=0; i < results[0].address_components.length; i++) {
          for (var j=0; j < results[0].address_components[i].types.length; j++) {
            if (results[0].address_components[i].types[j] == "country") {
              country = results[0].address_components[i];
              console.log(country.long_name)
              console.log(country.short_name)
              flag =true;
              break;
            }  /* end of if */    
          }/* end of J-for */
          if(flag){break;}
        }/* end of I-for */
        
        	$.get("GoogleAPI",{country:country.long_name}).done(function(response){
        		console.log(response);
        		var htm="";
        		$.each(response,function(index,value){
        			htm+="<div style='color:blue;'>"+value+"</div>";
        		});
        		$(".modal-body").html(htm);
        		$('#myModal').modal('show');
        	});


        }/*if status google coder  */
      });/* end of geocoder.geocode */
    });/* end of event listener  */
      }/* end of init() */
      
      $(document).ready(function(){
    	  $('#loading-image').bind('ajaxStart', function(){
    		    $(this).show();
    		}).bind('ajaxStop', function(){
    		    $(this).hide();
    		});
      });
    </script>
    
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAU6Znsgq-RhY9uyxp0bkJfzQSWD5P-F3Q&callback=initMap"
    async defer>

    </script>
   
  </body>
</html>