<template>
  <div>
    <div class="status-message" v-show="errorMsg != ''">{{ errorMsg }}</div>
    <b-form @submit="onSubmit" @reset="onReset" v-if="show" class="b-form">
      <h2>Add a Property</h2>
      <b-form-group
        id="input-group-1"
        label="Address:"
        label-for="input-1"
        description="We'll never share your info with anyone else."
      >
        <b-form-input
          id="input-1"
          v-model="property.address.addressLine"
          type="text"
          placeholder="Enter street address"
          required
        ></b-form-input>
        <b-form-input
          id="input-1"
          v-model="property.address.city"
          type="text"
          placeholder="Enter city"
          required
        ></b-form-input>
        <b-form-input
          id="input-1"
          v-model="property.address.state"
          type="text"
          placeholder="Enter state"
          required
        ></b-form-input>
        <b-form-input
          id="input-1"
          v-model="property.address.zipCode"
          placeholder="Enter zipcode"
          required
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-2" label="Type:" label-for="input-2">
        <b-form-select
          id="input-2"
          v-model="property.propertyType"
          :options="propertyTypes"
          required
        ></b-form-select>
      </b-form-group>

      <b-form-group id="input-group-3" label="Price" label-for="input-3">
        <b-form-input
          id="input-3"
          v-model="property.rentAmount"
          placeholder="Enter monthly rent"
          required
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-3" label="Size" label-for="input-3">
        <b-form-input
          id="input-3"
          v-model="property.size"
          placeholder="Enter property size"
          required
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-3" label="Description" label-for="input-3">
        <b-form-input
          id="input-3"
          v-model="property.description"
          placeholder="Enter a brief desription"
          required
        ></b-form-input>
      </b-form-group>

      <b-form-group
        class="input-group-4"
        label="Number of Bedrooms:"
        label-for="input-4"
      >
        <b-form-select
          id="input-4"
          v-model="property.numberOfBedrooms"
          :options="noOfRooms"
          required
        ></b-form-select>
      </b-form-group>
      <b-form-group
        class="input-group-4"
        label="Number of Bathrooms:"
        label-for="input-4"
      >
        <b-form-select
          id="input-4"
          v-model="property.numberOfBathrooms"
          :options="noOfRooms"
          required
        ></b-form-select>
      </b-form-group>

      <b-form-group id="input-group-4">
        <b-form-checkbox v-model="property.pet">Pets Allowed</b-form-checkbox>
        <b-form-checkbox v-model="property.washer">Washer</b-form-checkbox>
        <b-form-checkbox v-model="property.dryer">Dryer</b-form-checkbox>
        <b-form-checkbox v-model="property.dishWasher"
          >Dishwasher</b-form-checkbox
        >
      </b-form-group>

      <b-button type="submit" variant="primary">Submit</b-button>
      <b-button type="reset" variant="danger">Reset</b-button>
    </b-form>
  </div>
</template>

<script>
import propertyService from "../../services/PropertyService";
export default {
  data() {
    return {
      errorMsg: "",
      property: {
        imageName: "1001.jpg",
        propertyType: null,
        numberOfBedrooms: null,
        numberOfBathrooms: null,
        rentAmount: null,
        description: null,
        size: null,
        pet: false,
        washer: false,
        dryer: false,
        dishWasher: false,
        address: {
          addresLine: null,
          city: null,
          state: null,
          zipCode: null,
        },
        ownerId: this.$store.state.user.id,
      },
      propertyTypes: [
        { text: "Select One", value: null },
        "Single-Family Home",
        "Condo",
        "Town Home",
        "Apartment",
      ],
      noOfRooms: [{ text: "Select One", value: null }, 1, 2, 3, 4, 5],
      show: true,
    };
  },
  methods: {
    onSubmit(event) {
      event.preventDefault();
      propertyService
        .addProperty(this.property)
        .then((response) => {
          if (response.status == 201) {
            this.$router.push({ name: "dashboard-view" });
            this.errorMsg = "Successful";
          }
        })
        .catch((error) => {
          this.handleErrorResponse(error);
        });
      this.onReset(event);
    },
    onReset(event) {
      event.preventDefault();
      // Reset our form values
      (this.property.propertyType = ""),
        (this.property.numberOfBedrooms = null),
        (this.property.numberOfBathrooms = null),
        (this.property.price = null),
        (this.property.description = ""),
        (this.property.size = null),
        (this.property.pet = false),
        (this.property.washer = false),
        (this.property.dryer = false),
        (this.property.dishWasher = false),
        (this.property.address.addressLine = ""),
        (this.property.address.city = ""),
        (this.property.address.state = ""),
        (this.property.address.zipCode = null),
        (this.property.owner.ownerId = 1),
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