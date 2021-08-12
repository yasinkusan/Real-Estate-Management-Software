<template>
  <div>
    <div class="search-bar">
      <!-- <label for="zip">Search </label> -->
      <span class="search-icon">
        <i class="fa fa-search"></i>
      </span>
      <b-form-input
        class="input-search"
        type="text"
        name="zip"
        v-model="zipFilter"
        placeholder="Zip Code"
      />
    </div>
    <b-container>
      <b-row>
        <property-card
          class="prop-card"
          v-bind:property="property"
          v-for="property in filteredProperties"
          v-bind:key="property.propertyId"
        />
      </b-row>
    </b-container>
  </div>
</template>

<script>
import propertyService from "../../services/PropertyService.js";
import PropertyCard from "../../components/CommonComponent/PropertyCard";

export default {
  name: "property-list",
  components: {
    PropertyCard,
  },

  data() {
    return {
      zipFilter: "",
      properties: [],
    };
  },
  computed: {
    filteredProperties() {
      return this.properties.filter((property) => {
        return this.zipFilter == ""
          ? true
          : property.address.zipCode.toString().startsWith(this.zipFilter);
      });
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
.row {
  display: flex;
  justify-content: center;
  margin: 0px;
  padding-bottom: 100px;
}
.container {
  width: 1100px;
}

.search-icon {
  position: absolute;
  top: 13px;
  left: 394px;
}
.input-search {
  padding-left: 25px;
  margin-right: 460px;
  margin-left: 360px;
  border-width: 3px;
  box-shadow: rgba(0, 0, 0, 0.2) 0px 5px 15px;
  height: 50px;
}

.search-bar {
  position: relative;
  display: flex;
  justify-content: center;
  align-items: center;
  align-content: center;
  margin-bottom: 3%;
  margin-top: 3%;
  margin-left: 3%;
  font-size: 15px;
  word-spacing: 2px;
  font-weight: 700;
  text-decoration: none;
  font-style: normal;
  font-variant: normal;
  text-transform: none;
  border-color: blue;
  padding-left: 25px;
}
.prop-card {
  padding-bottom: 20px;
}
</style>