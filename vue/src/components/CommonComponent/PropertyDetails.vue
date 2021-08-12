<template>
  <div>
    <div class="row">
      <div class="column">
        <div class="slider">
          <a @click="scrollToTop()" href="#slide-1" class="mybar"
            ><img class="image-bar" :src="getImageURL(property.imageName)"
          /></a>
          <a v-on:click="scrollToTop()" href="#slide-2" class="mybar"
            ><img class="image-bar" :src="getImageURL('livingroom.jpg')"
          /></a>
          <a @click="scrollToTop()" href="#slide-3" class="mybar"
            ><img class="image-bar" :src="getImageURL('kitchen.jpg')"
          /></a>
          <a href="#slide-4" class="mybar"
            ><img class="image-bar" :src="getImageURL('bedroom.jpg')"
          /></a>
          <a href="#slide-5" class="mybar"
            ><img class="image-bar" :src="getImageURL('bathroom.jpg')"
          /></a>

          <div class="slides">
            <div id="slide-1">
              <img :src="getImageURL(property.imageName)" />
            </div>
            <div id="slide-2"><img :src="getImageURL('livingroom.jpg')" /></div>
            <div id="slide-3"><img :src="getImageURL('kitchen.jpg')" /></div>
            <div id="slide-4"><img :src="getImageURL('bedroom.jpg')" /></div>
            <div id="slide-5"><img :src="getImageURL('bathroom.jpg')" /></div>
          </div>
        </div>
        <div class="">
          <b-card-text class="address-map">
            <div class="address">
              {{ property.address.addressLine }}, {{ property.address.city }},
              {{ property.address.state }}, {{ property.address.zipCode }}
            </div>
            <b-button variant="info" class="map">View in Map</b-button>
          </b-card-text>
        </div>
      </div>
      <div class="column">
        <div>
          <h3>${{ property.rentAmount }}/mo</h3>
        </div>
        <div>
          <b-card-text class="rooms">
            <div>
              <i class="fa fa-bed"></i>: {{ property.numberOfBedrooms }}
            </div>
            <div>
              <i class="fa fa-bath"></i>: {{ property.numberOfBathrooms }}
            </div>
            <div><i class="fa fa-square"></i>: {{ property.size }} sqft</div>
          </b-card-text>
          <b-card-text class="amenities">
            <div v-if="property.pets ? (this.text = 'Yes') : 'No'">
              <i class="fa fa-paw"> </i>:
              {{ text }}
            </div>
            <div v-if="property.dryer ? (this.text = 'Yes') : 'No'">
              Dryer: {{ text }}
            </div>
            <div v-if="property.washer ? (this.text = 'Yes') : 'No'">
              Washer: {{ text }}
            </div>
            <div v-if="property.washer ? (this.text = 'Yes') : 'No'">
              Dishwasher: {{ text }}
            </div>
          </b-card-text>
          <div class="buttons">
            <router-link
              :to="{
                name: 'apply-property-form',
                params: { propertyId: property.propertyId },
              }"
            >
              <b-button variant="success">Apply</b-button></router-link
            >
            <b-button variant="primary">Contact</b-button>
          </div>
          <div>
            <h3>Details</h3>
            <p>{{ property.description }}</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import propertyService from "../../services/PropertyService.js";
export default {
  name: "property-details",
  data() {
    return {
      text: "No",
      properties: [],
    };
  },

  computed: {
    property() {
      const filtredProperty = this.properties.filter(
        (prop) => prop.propertyId == this.$route.params.propertyId
      );
      return filtredProperty[0];
    },
  },
  methods: {
    scrollToTop() {
      window.scrollToTop(0, 0);
    },
    getImageURL(pic) {
      return require("../../assets/img/" + pic);
    },
  },
  created() {
    propertyService.retrieveProperties().then((response) => {
      this.properties = response.data;
    });
  },
};
</script>

<style scoped>
#app
  > div:nth-child(2)
  > div
  > div
  > div:nth-child(2)
  > div:nth-child(2)
  > p.card-text.rooms
  > .icons {
  width: 10px;
  height: 10px;
}
#app > div:nth-child(2) > div > div > div:nth-child(2) > div:nth-child(2) {
  box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;
  padding: 28px;
}

#app
  > div:nth-child(2)
  > div
  > div
  > div:nth-child(1)
  > div:nth-child(2)
  > div {
  margin-bottom: 28px;
}
#app
  > div:nth-child(2)
  > div
  > div
  > div:nth-child(2)
  > div:nth-child(2)
  > p.card-text.rooms {
  display: flex;
  justify-content: space-evenly;
}

.column {
  width: 45%;
  margin: 5px 30px;
}
.row:after {
  content: "";
  display: table;
  clear: both;
}

img {
  width: 100%;
  border: solid 3px white;
  box-shadow: rgb(38, 57, 77) 0px 10px 20px -10px;
  position: absolute;
  top: 0;
  left: 0;
  height: 100%;
}
.buttons {
  display: flex;
  justify-content: space-evenly;
  margin-top: 20px;
}
.amenities {
  display: flex;
  justify-content: space-evenly;
}
.address-map {
  display: flex;
  justify-content: space-around;
  padding: 10px 3px;
  margin-top: 8px;
  margin-bottom: 30px;
  box-shadow: rgba(0, 0, 0, 0.2) 0px 5px 10px;
}
.address {
  font-size: 20px;
}
p.card-text.rooms {
  font-size: 20px;
}
* {
  box-sizing: border-box;
}

.image-bar {
  width: 90px;
  height: 70px;
}
#app
  > div:nth-child(2)
  > div
  > div
  > div:nth-child(2)
  > div:nth-child(2)
  > div:nth-child(4)
  > h3 {
  margin-top: 30px;
}
.slides {
  display: flex;
  margin-left: 20px;
  overflow-x: auto;
  scroll-snap-type: x mandatory;

  /* scroll-behavior: smooth; */
  -webkit-overflow-scrolling: touch;

  scroll-snap-points-x: repeat(300px);
  scroll-snap-type: mandatory;
}
.slides::-webkit-scrollbar {
  width: 10px;
  height: 10px;
}
.slides::-webkit-scrollbar-thumb {
  background: black;
  border-radius: 10px;
}
.slides::-webkit-scrollbar-track {
  background: transparent;
}
.slides > div {
  scroll-snap-align: start;
  flex-shrink: 0;
  width: 300px;
  height: 300px;
  margin-right: 50px;
  border-radius: 10px;
  background: #eee;
  /* transform-origin: center center; */
  transform: scale(1);
  /* transition: transform 0.5s;
  position: relative; */

  /* display: flex;
  justify-content: center;
  align-items: center;
  font-size: 100px; */
}
/* .slides > div:target {
  /*   transform: scale(0.8); */
/* } */
.author-info {
  background: rgba(0, 0, 0, 0.75);
  color: white;
  padding: 0.75rem;
  text-align: center;
  position: absolute;
  bottom: 0;
  left: 0;
  width: 100%;
  margin: 0;
}
.author-info a {
  color: white;
}
img {
  /* object-fit: cover; */
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
}

.slider > a {
  display: inline-flex;
  width: 5rem;
  height: 4rem;
  background: white;
  text-decoration: none;
  align-items: center;
  justify-content: center;
  border-radius: 50%;
  margin: 0 0 0.5rem 0;
  position: relative;
}
.slider > a:active {
  top: 1px;
}
.slider > a:focus {
  background: #000;
}
.slides > div {
  width: 400px;
}
.slider {
  width: 500px;
  text-align: center;
  overflow: hidden;
  margin: auto;
}
/* Don't need button navigation */
/* @supports (scroll-snap-type) {
  .slider > a {
    display: none;
  }
} */
#app > div:nth-child(2) > div > div > div:nth-child(1) > div.slider {
  width: 430px;
}

#app > div:nth-child(2) > div > div {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  /* margin-right: -15px; */
  /* margin-left: -15px; */
  width: 100%;
  margin-top: 30px;
}
</style>