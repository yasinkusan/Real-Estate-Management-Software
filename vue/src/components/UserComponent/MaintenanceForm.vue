<template>
  <div>
    <b-form @submit="onSubmit" @reset="onReset" v-if="show" class="b-form">
      <h2>Maintenance Form</h2>
      <b-form-group id="input-group-1" label="First Name" label-for="input-1">
        <b-form-input
          id="input-1"
          v-model="maintenance.firstName"
          placeholder="First Name"
          required
        ></b-form-input>
      </b-form-group>
      <b-form-group id="input-group-2" label="Last Name" label-for="input-2">
        <b-form-input
          id="input-2"
          v-model="maintenance.lastName"
          placeholder="Last Name"
          required
        ></b-form-input>
      </b-form-group>
      <b-form-group id="input-group-3" label="Email" label-for="input-3">
        <b-form-input
          id="input-3"
          v-model="maintenance.email"
          placeholder="Email"
          required
        ></b-form-input>
      </b-form-group>
      <b-form-group id="input-group-4" label="Phone" label-for="input-4">
        <b-form-input
          id="input-4"
          v-model="maintenance.phone"
          placeholder="Phone Number"
          required
        ></b-form-input>
      </b-form-group>
      <b-form-group
        id="input-group-5"
        label="Address:"
        label-for="input-5"
        description="We'll never share your info with anyone else."
      >
        <b-form-input
          id="input-5"
          v-model="maintenance.address.addressLine"
          type="text"
          placeholder="Enter street address"
          required
        ></b-form-input>
        <b-form-input
          id="input-5"
          v-model="maintenance.address.city"
          type="text"
          placeholder="Enter city"
          required
        ></b-form-input>
        <b-form-input
          id="input-5"
          v-model="maintenance.address.state"
          type="text"
          placeholder="Enter state"
          required
        ></b-form-input>
        <b-form-input
          id="input-5"
          v-model="maintenance.address.zipCode"
          placeholder="Enter zipcode"
          required
        ></b-form-input>
      </b-form-group>

      <b-form-group
        id="input-group-6"
        label="Maintenance Issue"
        label-for="input-5"
      >
        <b-form-textarea
          id="input-6"
          v-model="maintenance.issue"
          placeholder="Maintenance Issue"
          required
        ></b-form-textarea>
      </b-form-group>

      <b-button type="submit" variant="primary">Submit</b-button>
      <b-button type="reset" variant="danger">Reset</b-button>
    </b-form>
  </div>
</template>

<script>
import maintenanceService from "../../services/MaintenanceService";
export default {
  name: "maintenance-form",
  data() {
    return {
      errorMsg: "",
      maintenance: {
        userId: this.$store.state.user.id,
        firstName: "",
        lastName: "",
        email: "",
        phone: "",
        address: {
          addresLine: null,
          city: null,
          state: null,
          zipCode: null,
        },
        issue: "",
        date: new Date(),
        status: "requested",
      },
      show: true,
    };
  },
  methods: {
    onSubmit(event) {
      event.preventDefault();
      maintenanceService
        .addMaintenanceRequest(this.maintenance)
        .then((response) => {
          if (response.status == 201) {
            this.$router.push({ name: "dashboard-view" });
          }
        })
        .catch((error) => {
          this.handleErrorResponse(error);
        });
    },
    onReset(event) {
      event.preventDefault();
      // Reset our form values
      (this.maintenance.firstName = ""),
        (this.maintenance.lastName = ""),
        (this.maintenance.email = ""),
        (this.maintenance.phone = ""),
        (this.maintenance.address.addressLine = ""),
        (this.maintenance.address.city = ""),
        (this.maintenance.address.state = ""),
        (this.maintenance.address.zipCode = null),
        (this.maintenance.issue = ""),
        // Trick to reset/clear native browser form validation state
        (this.show = false);
      this.$nextTick(() => {
        this.show = true;
      });
    },

    handleErrorResponse(error) {
      if (error.response) {
        this.errorMsg =
          "Error requesting maintenance. Error: " + error.response.status;
      } else if (error.request) {
        this.errorMsg =
          "Error requesting maintenance. Server unavailable, Error: " +
          error.status;
      } else {
        this.errorMsg =
          "Request for maintenance is not successfull. Try again later.";
      }
    },
  },
};
</script>

<style scoped>
.b-form {
  padding: 10px 10px;
  margin: 3% 35%;
  border-radius: 10px;
  box-shadow: rgba(0, 0, 0, 0.25) 0px 54px 55px,
    rgba(0, 0, 0, 0.12) 0px -12px 30px, rgba(0, 0, 0, 0.12) 0px 4px 6px,
    rgba(0, 0, 0, 0.17) 0px 12px 13px, rgba(0, 0, 0, 0.09) 0px -3px 5px;
}
</style>