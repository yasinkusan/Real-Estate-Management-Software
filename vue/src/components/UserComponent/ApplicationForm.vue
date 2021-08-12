<template>
  <div>
    <b-form @submit="onSubmit" @reset="onReset" v-if="show" class="b-form">
      <h2>Application Form</h2>
      <b-form-group id="input-group-1" label="First Name" label-for="input-1">
        <b-form-input
          id="input-1"
          v-model="application.firstName"
          placeholder="First Name"
          required
        ></b-form-input>
      </b-form-group>
      <b-form-group id="input-group-2" label="Last Name" label-for="input-2">
        <b-form-input
          id="input-2"
          v-model="application.lastName"
          placeholder="Last Name"
          required
        ></b-form-input>
      </b-form-group>
      <b-form-group id="input-group-3" label="Email" label-for="input-3">
        <b-form-input
          id="input-3"
          v-model="application.email"
          placeholder="Email"
          required
        ></b-form-input>
      </b-form-group>
      <b-form-group id="input-group-4" label="Phone" label-for="input-4">
        <b-form-input
          id="input-4"
          v-model="application.phone"
          placeholder="Phone Number"
          required
        ></b-form-input>
      </b-form-group>
      <b-form-group
        id="input-group-5"
        label="Annual Income"
        label-for="input-5"
      >
        <b-form-input
          id="input-5"
          v-model="application.income"
          placeholder="Income"
          required
        ></b-form-input>
      </b-form-group>

      <b-button type="submit" variant="primary">Submit</b-button>
      <b-button type="reset" variant="danger">Reset</b-button>
    </b-form>
  </div>
</template>

<script>
import propertyService from "../../services/PropertyService";
export default {
  name: "application-form",
  data() {
    return {
      errorMsg: "",
      application: {
        applicationDate: new Date(),
        firstName: "",
        lastName: "",
        email: "",
        phone: "",
        income: "",
        propertyId: this.$route.params.propertyId,
        userId: this.$store.state.user.id,
      },
      show: true,
    };
  },
  methods: {
    onSubmit(event) {
      event.preventDefault();
      propertyService
        .applyProperty(this.application)
        .then((response) => {
          if (response.status == 201) {
            this.$router.push({ name: "property-list-view" });
          }
        })
        .catch((error) => {
          this.handleErrorResponse(error);
        });
    },
    onReset(event) {
      event.preventDefault();
      // Reset our form values
      (this.application.firstName = ""),
        (this.application.lastName = ""),
        (this.application.email = ""),
        (this.application.phone = ""),
        (this.application.income = ""),
        // Trick to reset/clear native browser form validation state
        (this.show = false);
      this.$nextTick(() => {
        this.show = true;
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
};
</script>

<style scoped>
.b-form {
  margin: 3% 30%;
  box-shadow: rgb(0 0 0 / 25%) 0px 54px 55px, rgb(0 0 0 / 12%) 0px -12px 30px,
    rgb(0 0 0 / 12%) 0px 4px 6px, rgb(0 0 0 / 17%) 0px 12px 13px,
    rgb(0 0 0 / 9%) 0px -3px 5px;
  padding: 10px;
  border-radius: 10px;
}
</style>