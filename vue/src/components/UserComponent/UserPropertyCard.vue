<template>
  <div>
    <div class="main-container">
      <div class="col">
        <div class="card h-100 shadow-sm">
          <div class="card-body">
            <img
              :src="getImageURL(property.imageName)"
              class="card-img-top"
              alt="..."
            />
            <h5 class="card-title">
              {{ property.address.addressLine }}, {{ property.address.city }},
              {{ property.address.state }}, {{ property.address.zipCode }}
            </h5>
            <div class="text-center my-4">
              <router-link
                v-bind:to="{
                  name: 'payment-view',
                  params: { propertyId: property.propertyId },
                }"
                class="btn btn-warning"
                >PAY RENT</router-link
              >
            </div>

            <div class="text-center my-4">
              <router-link
                v-bind:to="{ name: 'maintenance-request-form' }"
                class="btn btn-warning"
                >REQUEST SERVICE</router-link
              >
            </div>
            <div class="text-center my-4">
              <button v-on:click="toggle" class="btn btn-warning">
                SHOW PAYMENTS
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="payments" v-show="isActive ? true : false">
      <payment-history />
    </div>
  </div>
</template>

<script>
import PaymentHistory from "./PaymentHistory.vue";
export default {
  components: { PaymentHistory },
  data() {
    return {
      isActive: false,
    };
  },
  props: {
    property: Object,
  },

  methods: {
    toggle() {
      this.isActive = this.isActive ? false : true;
    },

    getImageURL(pic) {
      return require("../../assets/img/" + pic);
    },
  },
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800;900&display=swap");

* {
  margin: 0;
  padding: 0;
  font-family: "Poppins", sans-serif;
}
body {
  min-width: 100vw;
  min-height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  background: #16384c;
}

.container .card {
  max-width: 600px;
  height: 215px;
  margin: 30px 10px;
  padding: 20px 15px;
  box-shadow: 0 5px 20px rgba(0, 0, 0, 0.5);
  transition: 0.3s ease-in-out;
}

.container .card:hover {
  height: 450px;
}

.container .card .imgContainer {
  position: relative;
  width: 250px;
  height: 250px;
  top: -50px;
  left: 10px;
  z-index: 1;
  box-shadow: 0 5px 20px rgba(0, 0, 0, 0.2);
}

.container .card .imgContainer img {
  max-width: 100%;
  border-radius: 4px;
}

.container .card .content {
  position: relative;
  margin-top: -140px;
  padding: 10px 15px;
  text-align: center;
  color: #111;
  visibility: hidden;
  opacity: 0;
  pointer-events: none;
  transition: 0.3s ease-in-out;
}

.container .card:hover .content {
  visibility: visible;
  opacity: 1;
  margin-top: -40px;
  transition-delay: 0.3s;
}

@media (max-width: 330px) {
  .container .card .imgContainer {
    left: -2px;
  }
}
/* .main-container {
} */

.Welcome {
  display: flex;
  justify-content: center;
  margin-top: 20px;
  margin-bottom: 30px;
}

@import url("https://fonts.googleapis.com/css2?family=Fira+Sans+Extra+Condensed:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap");
@import url("https://fonts.googleapis.com/css2?family=Heebo:wght@100;200;300;400;500;600;700;800;900&display=swap");
@import url("https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap");

:root {
  --font1: "Heebo", sans-serif;
  --font2: "Fira Sans Extra Condensed", sans-serif;
  --font3: "Roboto", sans-serif;
}

/* body {
  font-family: var(--font3);
  background-image: linear-gradient(120deg, #fdfbfb 0%, #ebedee 100%);
} */

h2 {
  font-weight: 900;
}

.container-fluid {
  max-width: 1200px;
}

.card {
  background: #fff;
  box-shadow: rgb(0 0 0 / 25%) 0px 54px 55px, rgb(0 0 0 / 12%) 0px -12px 30px,
    rgb(0 0 0 / 12%) 0px 4px 6px, rgb(0 0 0 / 17%) 0px 12px 13px,
    rgb(0 0 0 / 9%) 0px -3px 5px;
  transition: 0.3s transform cubic-bezier(0.155, 1.105, 0.295, 1.12),
    0.3s box-shadow,
    0.3s -webkit-transform cubic-bezier(0.155, 1.105, 0.295, 1.12);
  border: 0;
  border-radius: 1rem;
  /* box-shadow: rgb(38, 57, 77) 0px 20px 30px -10px; */
  margin-bottom: 80px;
}

.card-img,
.card-img-top {
  border-top-left-radius: calc(1rem - 1px);
  border-top-right-radius: calc(1rem - 1px);
}

.card h5 {
  overflow: hidden;
  height: auto;
  font-weight: 200;
  font-size: 1rem;
}

.card-img-top {
  width: 100%;
  max-height: 180px;
  /* object-fit: contain; */
  padding: 5px 5px 5px 5px;
  border-radius: 30px;
}

.card h2 {
  font-size: 1rem;
}

.card:hover {
  transform: scale(1.05);
  box-shadow: 0 10px 20px rgba(0, 0, 0, 0.12), 0 4px 8px rgba(0, 0, 0, 0.06);
}

.label-top {
  position: absolute;
  background-color: #8bc34a;
  color: #fff;
  top: 8px;
  right: 8px;
  padding: 5px 10px 5px 10px;
  font-size: 0.7rem;
  font-weight: 600;
  border-radius: 3px;
  text-transform: uppercase;
}

.top-right {
  position: absolute;
  top: 24px;
  left: 24px;
  width: 90px;
  height: 90px;
  border-radius: 50%;
  font-size: 1rem;
  font-weight: 900;
  background: #ff5722;
  line-height: 90px;
  text-align: center;
  color: white;
}

.top-right span {
  display: inline-block;
  vertical-align: middle;
}

@media (max-width: 768px) {
  .card-img-top {
    max-height: 250px;
  }
}

.over-bg {
  background: rgba(53, 53, 53, 0.85);
  box-shadow: 0 8px 32px 0 rgba(31, 38, 135, 0.37);
  backdrop-filter: blur(0px);
  -webkit-backdrop-filter: blur(0px);
  border-radius: 10px;
}

.btn {
  font-size: 1rem;
  font-weight: 500;
  text-transform: uppercase;
  padding: 5px 50px 5px 50px;
  width: 90%;
}

.box .btn {
  font-size: 1.5rem;
}

@media (max-width: 1025px) {
  .btn {
    padding: 5px 40px 5px 40px;
  }
}

@media (max-width: 250px) {
  .btn {
    padding: 5px 10px 5px 10px;
  }
}

.btn-warning {
  background: hsl(197, 100%, 68%);
  color: black;
  fill: #ffffff;
  border: none;
  text-decoration: none;
  outline: 0;
  box-shadow: -1px 6px 20px black;
  border-radius: 100px;
  margin-bottom: 10px;
}

.btn-warning:hover {
  background: hsl(197, 100%, 56%);
  color: #ffffff;
  box-shadow: -1px 6px 13px rgb(0, 0, 0);
}

.bg-success {
  font-size: 1rem;
  background-color: #f7810a !important;
}

.bg-danger {
  font-size: 1rem;
}

.price-hp {
  font-size: 1rem;
  font-weight: 600;
  color: darkgray;
}

.amz-hp {
  font-size: 0.7rem;
  font-weight: 600;
  color: darkgray;
}

.fa-question-circle:before {
  color: darkgray;
}

.fa-plus:before {
  color: darkgray;
}

.box {
  border-radius: 1rem;
  background: #fff;
  box-shadow: 0 6px 10px rgb(0 0 0 / 8%), 0 0 6px rgb(0 0 0 / 5%);
  transition: 0.3s transform cubic-bezier(0.155, 1.105, 0.295, 1.12),
    0.3s box-shadow,
    0.3s -webkit-transform cubic-bezier(0.155, 1.105, 0.295, 1.12);
}

.box-img {
  max-width: 300px;
}

.thumb-sec {
  max-width: 300px;
}

@media (max-width: 576px) {
  .box-img {
    max-width: 200px;
  }

  .thumb-sec {
    max-width: 200px;
  }
}

.inner-gallery {
  width: 60px;
  height: 60px;
  border: 1px solid #ddd;
  border-radius: 3px;
  margin: 1px;
  display: inline-block;
  overflow: hidden;
  -o-object-fit: cover;
  object-fit: cover;
}

@media (max-width: 370px) {
  .box .btn {
    padding: 5px 40px 5px 40px;
    font-size: 1rem;
  }
}

.disclaimer {
  font-size: 0.9rem;
  color: darkgray;
}

.related h3 {
  font-weight: 900;
}

footer {
  background: #212529;
  height: 80px;
  color: #fff;
}

.col {
  width: 20%;
  margin: auto;
}
.card-title {
  display: flex;
  justify-content: center;
  padding-top: 20px;
}
.card-body {
  box-shadow: rgb(0 0 0 / 25%) 0px 54px 55px, rgb(0 0 0 / 12%) 0px -12px 30px,
    rgb(0 0 0 / 12%) 0px 4px 6px, rgb(0 0 0 / 17%) 0px 12px 13px,
    rgb(0 0 0 / 9%) 0px -3px 5px;
  padding: 1px;
  border-radius: 10px;
}
.payments {
  margin-left: 200px;
  margin-bottom: 80px;
}
</style>
