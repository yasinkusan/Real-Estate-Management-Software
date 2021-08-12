<template>
  <div class="container-fluid">
    <div class="row justify-content-center">
      <div class="card my-4 p-3">
        <div class="row main">
          <div class="col-12">
            <span>Checkout</span>
          </div>
        </div>
        <div class="row justify-content-center mrow">
          <div class="col-12">
            <img
              class="image"
              src="https://img.icons8.com/color/48/000000/mastercard-logo.png"
            />
            <img
              class="image"
              src="https://img.icons8.com/color/48/000000/visa.png"
            />
            <img
              class="image"
              src="https://img.icons8.com/color/48/000000/paypal.png"
            />
          </div>
        </div>
        <form class="form-card">
          <div class="row">
            <div class="col-12">
              <div class="form-group">
                <input
                  type="text"
                  class="form-control p-0"
                  id="number"
                  required
                /><label class="form-control-placeholder p-0" for="number"
                  >CardNumber</label
                >
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-12">
              <div class="form-group">
                <input
                  type="text"
                  class="form-control p-0"
                  id="name"
                  required
                /><label class="form-control-placeholder p-0" for="name"
                  >Cardholder'sName</label
                >
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-sm-4 col-12">
              <div class="form-group">
                <input
                  type="text"
                  class="form-control p-0"
                  id="sdate"
                  required
                /><label class="form-control-placeholder p-0" for="sdate"
                  >StartDate</label
                >
              </div>
            </div>
            <div class="col-sm-4 col-12">
              <div class="form-group">
                <input
                  type="text"
                  class="form-control p-0"
                  id="expdate"
                  required
                /><label class="form-control-placeholder p-0" for="expdate"
                  >ExpirationDate</label
                >
              </div>
            </div>
            <div class="col-sm-4 col-12">
              <div class="form-group">
                <input
                  type="password"
                  class="form-control p-0"
                  id="passw"
                  required
                /><label class="form-control-placeholder p-0" for="passw"
                  >CVV</label
                >
              </div>
            </div>
          </div>
          <div class="row lrow mt-4 mb-3">
            <div class="col-sm-8 col-12">
              <h3>Grand Total:</h3>
            </div>
            <div class="col-sm-4 col-12">
              <h5>&#36;{{ filtredProperty.rentAmount }}</h5>
            </div>
          </div>
          <div class="row mb-2">
            <div class="col-sm-12">
              <button
                type="button"
                class="btn btn-primary btn-block"
                v-on:click="onSubmit"
              >
                Pay
              </button>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import propertyService from "../../services/PropertyService.js";
import paymentService from "../../services/PaymentService.js";

export default {
  name: "payment-component",
  data() {
    return {
      errorMsg: "",
      payment: {
        date: new Date(),
        amount: 1000,
        propertyId: this.$route.params.propertyId,
        userId: this.$store.state.user.id,
      },
      show: true,

      properties: [],
    };
  },
  computed: {
    filtredProperty() {
      let myFiltredProperty = this.properties.filter(
        (prop) => prop.propertyId == this.$route.params.propertyId
      );

      return myFiltredProperty[0];
    },
  },
  methods: {
    //     putAmout(amount){
    // this.payment.amount= amount
    //     },
    onSubmit(event) {
      event.preventDefault();
      paymentService
        .addPayment(this.payment)
        .then((response) => {
          if (response.status == 201) {
            this.$router.push({ name: "dashboard-view" });
          }
        })
        .catch((error) => {
          this.handleErrorResponse(error);
        });
    },

    handleErrorResponse(error) {
      if (error.response) {
        this.errorMsg =
          "Error adding a new property. Error: " + error.response.status;
      } else if (error.request) {
        this.errorMsg =
          "Error adding a new property. Server unavailable, Error: " +
          error.status;
      } else {
        this.errorMsg = "Adding property is not successfull. Try again later.";
      }
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
body {
  font-family: Arial, Helvetica, sans-serif;
  background: #343a40;
}

.card {
  background-color: rgb(235, 186, 168);
  color: #fff;
  width: 410px !important;
}

.mrow {
  margin-top: 30px;
  margin-bottom: 30px;
}

img {
  margin-right: 10px;
}

.image {
  width: 35px;
}

.main span:hover {
  text-decoration: underline;
  cursor: pointer;
}

.mrow img:hover {
  border-bottom: 1px solid #fff;
  cursor: pointer;
}

.btn-primary {
  border: none;
  border-radius: 30px;
}

h5 {
  padding-top: 8px;
}

.form-group {
  position: relative;
  margin-bottom: 2rem;
}

.form-control-placeholder {
  position: absolute;
  top: 6px;
  padding: 7px 0 0 10px;
  transition: all 200ms;
  opacity: 1;
  color: #000 !important;
  font-size: 75%;
}

.form-control:focus + .form-control-placeholder,
.form-control:valid + .form-control-placeholder {
  font-size: 75%;
  transform: translate3d(0, -100%, 0);
  opacity: 1;
  top: 10px;
}

.form-control {
  background: transparent;
  border: none;
  border-bottom: 1px solid black !important;
  border-radius: 0;
  outline: 0;
}

.form-control:focus,
.form-control:after {
  outline-width: 0;
  border-bottom: 1px solid black !important;
  background: transparent;
  box-shadow: none;
  border-radius: 0;
  color: black;
  letter-spacing: 1px;
}

.col-12 {
  color: #000;
}

.mrow > .col-12 {
  display: flex;
  width: 100px;
}
.card {
  background-color: white;
  padding: 10px 10px;
  margin: 3% 35% 30% 35%;
  border-radius: 10px;
  box-shadow: rgb(0 0 0 / 25%) 0px 54px 55px, rgb(0 0 0 / 12%) 0px -12px 30px,
    rgb(0 0 0 / 12%) 0px 4px 6px, rgb(0 0 0 / 17%) 0px 12px 13px,
    rgb(0 0 0 / 9%) 0px -3px 5px;
}
.container-fluid {
  margin-bottom: 5%;
  margin-top: 3%;
}
</style>