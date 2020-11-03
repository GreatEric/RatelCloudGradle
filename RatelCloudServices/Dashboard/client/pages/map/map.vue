<template>
  <div>
    <div class="googleMapContainer" id="googleMapContainer"></div>

    <input type="text" placeholder="from" v-model="from" v-on:input="geocodeAddress(from)"/>
    <input type="text" placeholder="to" v-model="to"/>
    <button @click="calc_distance">calculate</button>

    <h3>{{distance}}</h3>

    <div id="output"></div>
  </div>
</template>

<script>
  import googleMapkey from '../../configs/globalconfig';
  export default {
    name: "GoogleMap",
    layout: 'dashboard1',
    data: () => ({
      map: null,
      geocoder: null,
      LatLng: {lat: 40.774102, lng: -73.971734},
      zoom: 10,
      scaleControl: true,
      center: null,
      markerImg: 'http://localhost:8080/house/commerce/html/home.html',
      title: 'company name',
      marker: null,
      from:'',
      to:'',
      distance: ''
    }),
    mounted(){
      this.$myInjectedFunction('test')

      this.$vs2.load('https://maps.googleapis.com/maps/api/js?key='+googleMapkey).then(() => {
        this.initMap3();
      });
    },
    methods:{
      initMap1(){
        this.center = this.LatLng;
        this.map = new google.maps.Map(document.getElementById('googleMapContainer'), {
          zoom: this.zoom,
          center: this.LatLng
        });
        this.marker = new google.maps.Marker({
          map: this.map,
          draggable: true,
          animation: google.maps.Animation.DROP,
          position: this.LatLng,
          // icon: image
          title: this.title
        });
        this.marker.addListener('click', this.toggleBounce);
      },
      initMap2() {
        // The map, centered on Central Park
        const center = {lat: 40.774102, lng: -73.971734};
        const options = {zoom: 15, scaleControl: true, center: center};
        this.map = new google.maps.Map(document.getElementById('googleMapContainer'), options);

        this.geocoder = new google.maps.Geocoder();

        // Locations of landmarks
        const dakota = {lat: 40.7767644, lng: -73.9761399};
        const frick = {lat: 40.771209, lng: -73.9673991};
        let mk1 = new google.maps.Marker({position: dakota, map: this.map});
        let mk2 = new google.maps.Marker({position: frick, map: this.map});

        // Draw a line showing the straight distance between the markers
        let line = new google.maps.Polyline({path: [dakota, frick], map: this.map});


        let dis = this.calc_distance(mk1, mk2);
        this.distance = "Distance between markers: " + dis.toFixed(2) + " miles.";
      },
      initMap3() {
        var bounds = new google.maps.LatLngBounds;
        var markersArray = [];

        var origin1 = {lat: 55.93, lng: -3.118};
        var origin2 = 'Greenwich, England';
        var destinationA = 'Stockholm, Sweden';
        var destinationB = {lat: 50.087, lng: 14.421};

        var destinationIcon = 'https://chart.googleapis.com/chart?' +
          'chst=d_map_pin_letter&chld=D|FF0000|000000';
        var originIcon = 'https://chart.googleapis.com/chart?' +
          'chst=d_map_pin_letter&chld=O|FFFF00|000000';
        var map = new google.maps.Map(document.getElementById('googleMapContainer'), {
          center: {lat: 55.53, lng: 9.4},
          zoom: 10
        });
        var geocoder = new google.maps.Geocoder;

        var service = new google.maps.DistanceMatrixService;
        service.getDistanceMatrix({
          origins: [origin1, origin2],
          destinations: [destinationA, destinationB],
          travelMode: 'DRIVING',
          unitSystem: google.maps.UnitSystem.METRIC,
          avoidHighways: false,
          avoidTolls: false
        }, (response, status)=> {
          if (status !== 'OK') {
            alert('Error was: ' + status);
          } else {
            var originList = response.originAddresses;
            var destinationList = response.destinationAddresses;
            var outputDiv = document.getElementById('output');
            outputDiv.innerHTML = '';
            this.deleteMarkers(markersArray);

            var showGeocodedAddressOnMap = function(asDestination) {
              var icon = asDestination ? destinationIcon : originIcon;
              return function(results, status) {
                if (status === 'OK') {
                  map.fitBounds(bounds.extend(results[0].geometry.location));
                  markersArray.push(new google.maps.Marker({
                    map: map,
                    position: results[0].geometry.location,
                    icon: icon
                  }));
                } else {
                  alert('Geocode was not successful due to: ' + status);
                }
              };
            };

            for (var i = 0; i < originList.length; i++) {
              var results = response.rows[i].elements;
              geocoder.geocode({'address': originList[i]},
                showGeocodedAddressOnMap(false));
              for (var j = 0; j < results.length; j++) {
                geocoder.geocode({'address': destinationList[j]},
                  showGeocodedAddressOnMap(true));
                outputDiv.innerHTML += originList[i] + ' to ' + destinationList[j] +
                  ': ' + results[j].distance.text + ' in ' +
                  results[j].duration.text + '<br>';
              }
            }
          }
        });
      },
      toggleBounce() {
        if (this.marker.getAnimation() !== null) {
          this.marker.setAnimation(null);
        } else {
          this.marker.setAnimation(google.maps.Animation.BOUNCE);
        }
      },
      deleteMarkers(markersArray) {
        for (var i = 0; i < markersArray.length; i++) {
          markersArray[i].setMap(null);
        }
        markersArray = [];
      },
      calc_distance(mk1, mk2) {
        var R = 3958.8; // Radius of the Earth in miles
        var rlat1 = mk1.position.lat() * (Math.PI/180); // Convert degrees to radians
        var rlat2 = mk2.position.lat() * (Math.PI/180); // Convert degrees to radians
        var difflat = rlat2-rlat1; // Radian difference (latitudes)
        var difflon = (mk2.position.lng()-mk1.position.lng()) * (Math.PI/180); // Radian difference (longitudes)

        var d = 2 * R * Math.asin(Math.sqrt(Math.sin(difflat/2)*Math.sin(difflat/2)+Math.cos(rlat1)*Math.cos(rlat2)*Math.sin(difflon/2)*Math.sin(difflon/2)));
        return d;
      },
      geocodeAddress(address) {
        this.geocoder.geocode({'address': address}, (results, status)=>{
          if (status === 'OK') {
            this.map.setCenter(results[0].geometry.location);
            let marker = new google.maps.Marker({
              map: this.map,
              position: results[0].geometry.location
            });
          } else {
            console.log('Geocode was not successful for the following reason: ' + status);
          }
        });
      }
    }
  }
</script>

<style scoped>
  .googleMapContainer{
    with: 1000px;
    height: 700px;
  }
</style>
