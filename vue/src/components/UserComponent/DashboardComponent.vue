<template>
  <div>
    <div class="Welcome">Welcome {{ this.$store.state.user.username }}</div>
    <user-property-card
      v-bind:property="property"
      v-for="property in properties"
      v-bind:key="property.propertyId"
    />
  </div>
</template>

<script>
import UserPropertyCard from "./UserPropertyCard.vue";
import propertyService from "../../services/PropertyService.js";

export default {
  components: { UserPropertyCard },
  name: "dashboard-component",

  data() {
    return {
      properties: [],
    };
  },

  created() {
    propertyService
      .getPropertiesForUser(this.$store.state.user.id)
      .then((response) => {
        this.properties = response.data;
      });
  },
};
</script>

<style scoped>
.Welcome {
  display: flex;
  justify-content: center;
  padding: 40px;
  font-family: sans-serif;
  font-size: 30px;
}
</style>