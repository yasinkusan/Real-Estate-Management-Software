<template>
  <div>
    <div class="container">
      <div class="logo">
        <img :src="getImageURL('logo.png')" />
        <p>Dwellings.com</p>
      </div>
      <div class="nav">
        <router-link v-bind:to="{ name: 'home' }" class="nav-item"
          >Home</router-link
        >
        <div
          class="nav-item"
          v-show="this.$store.state.user.id != null ? true : false"
        >
          <router-link v-bind:to="{ name: 'dashboard-view' }" class="nav-item"
            >Dashboard</router-link
          >
        </div>
        <router-link v-bind:to="{ name: 'property-list-view' }" class="nav-item"
          >Search Home</router-link
        >

        <div class="nav-item">
          <router-link v-bind:to="{ name: 'about-view' }" class="nav-item"
            >About</router-link
          >
        </div>
      </div>

      <div class="signin">
        <router-link
          v-bind:to="{ name: 'login' }"
          v-if="$store.state.token == ''"
          class="signin-item"
          >Login</router-link
        >
        <router-link
          v-bind:to="{ name: 'logout' }"
          v-if="$store.state.token != ''"
          class="signin-item"
          >Logout</router-link
        >
      </div>
    </div>
  </div>
</template>

<script>
export default {
  methods: {
    getImageURL(pic) {
      return require("../../assets/img/" + pic);
    },
  },
};
</script>

<style scoped>
#app > div:nth-child(1) > div > div.logo > p {
  margin: 0 auto;
}
div.container {
  max-width: 2000px;
  margin: 0px 0px;
  display: flex;
  justify-items: flex-start;
  justify-content: space-between;
  /* background-color: rgb(235, 186, 168); */
  background: hsl(197, 100%, 68%);
  padding-top: 10px;
  border-bottom: 3px solid rgb(0, 0, 0);
  padding-bottom: 6px;
  align-items: center;
}

.nav {
  width: 450px;
  display: flex;
  justify-items: flex-start;
  justify-content: space-between;
}
.p {
  margin: 0;
}

.nav-item:hover {
  color: black;
  opacity: 0.5;
  text-decoration: none;
}

.nav-item {
  color: black;
}

.signin-item {
  color: black;
}

.signin-item:hover {
  color: black;
  opacity: 0.5;
  text-decoration: none;
}
a {
  font-size: 20px;
}

#app > div:nth-child(1) > div > div.logo > img {
  width: 50px;
  height: 50px;
  margin-left: 25px;
}
</style>