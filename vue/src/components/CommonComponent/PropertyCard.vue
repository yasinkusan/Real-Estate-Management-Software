<template>
  <div>
    <b-col>
      <router-link
        :to="{
          name: 'property-detail',
          params: { propertyId: property.propertyId },
        }"
      >
        <b-card
          :title="'$' + property.rentAmount + '/mo'"
          tag="article"
          style="width: 20rem"
          class="mb-2"
        >
          <img :src="getImageURL(property.imageName)" class="image" />
          <b-card-text>
            {{ property.propertyType }}
          </b-card-text>
          <b-card-text>
            <i class="fa fa-bed"></i> {{ property.numberOfBedrooms }} bds /
            <i class="fa fa-bath"></i> {{ property.numberOfBathrooms }} ba /
            <i class="fa fa-square"></i> {{ property.size }} sqft
          </b-card-text>
          <b-card-text class="address">
            {{ property.address.addressLine }}, {{ property.address.city }},
            {{ property.address.state }}, {{ property.address.zipCode }}
          </b-card-text>
        </b-card>
      </router-link>
    </b-col>
  </div>
</template>

<script>
export default {
  name: "property-card",
  props: {
    property: Object,
  },
  methods: {
    getImageURL(pic) {
      return require("../../assets/img/" + pic);
    },
  },
};
</script>

<style lang="scss" scoped>
.image {
  width: 300px;
  height: 205px;
  border: solid 1px rgb(209, 198, 138);
  border-radius: 8px;
  // box-shadow: rgb(38, 57, 77) 0px 10px 20px -10px;
  margin: auto;
  box-shadow: none !important;
}
.address {
  font-size: 15px;
}
a:hover {
  color: black;
  text-decoration: none;
}
a {
  color: black;
}

.card-body {
  border-radius: 8px;
  border: solid 1px rgb(149, 167, 99);
  background-color: white;
  padding: 8px;
  box-shadow: rgba(99, 99, 99, 0.2) 0px 2px 8px 0px;
}
#app
  > div:nth-child(2)
  > div
  > div.container
  > div
  > div
  > div
  > a
  > article
  > div
  > p {
  margin-bottom: 0px;
  padding-bottom: 0px;
}
</style>