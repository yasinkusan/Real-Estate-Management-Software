<template>
  <div id="app">
    <the-header />

    <router-view />

    <the-footer />
  </div>
</template>

<script>
import TheFooter from "./components/CommonComponent/TheFooter";
import TheHeader from "./components/CommonComponent/TheHeader";

export default {
  name: "App",
  components: {
    TheHeader,
    TheFooter,
  },
};
</script>


<style lang="scss">
@import "~@/assets/scss/vendors/bootstrap-vue/index";

@import "~@/assets/scss/vendors/bootstrap-vue/index";

// #app {
//   background: beige;
// }
</style>