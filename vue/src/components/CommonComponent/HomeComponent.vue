<template>
  <div class="home-container">
    <div class="image">
      <img class="image-1" :src="getImageURL('homePage.jpg')" alt="" />
    </div>
    <div class="container-2">
      <div class="slogan">
        <h2 class="slogan-text">
          Whether you are window shopping or actively looking, start your home
          search here
        </h2>
      </div>
      <div class="get-started">
        <router-link :to="{ name: 'property-list-view' }">
          <b-button class="get-started-button" pill variant="primary"
            >Get Started</b-button
          >
        </router-link>
      </div>
      <div class="description">
        <h3></h3>
      </div>
      <div class="properties">
        <img src="http://localhost:8081/img/1000.5f917053.jpg" alt="" />
        <img
          src="https://www.haggertyrealestateservices.com/wp-content/uploads/2019/04/Dream-Home.jpg"
          alt=""
        />
        <img
          src="https://i.ytimg.com/vi/eL64ez1-xe4/maxresdefault.jpg"
          alt=""
        />
      </div>
      <div class="bottom-cards">
        <div class="bottom-card">
          <img
            src="	https://www.trulia.com/images/icons/txl3/illustrations/RentAHome.svg"
            alt=""
          />
          <h2>Rent a Home</h2>
          <p>
            With over 10+ filters and custom heyword search, Dwellers can help
            you easily find a home or apartment for rent that you'll love.
          </p>
          <b-button>Find a Rental</b-button>
        </div>
        <div class="bottom-card">
          <img
            src="https://www.trulia.com/images/icons/txl3/illustrations/BuyAHome.svg"
            alt=""
          />
          <h2>See School Districts</h2>
          <p>
            With over 1,000+ school districts available on the website, you can
            explore more about school districts.
          </p>
          <b-button>Find a School District</b-button>
        </div>
        <div class="bottom-card">
          <img
            src="	https://www.trulia.com/images/icons/txl3/illustrations/Neighborhoods.svg"
            alt=""
          />
          <h2>See Neighborhoods</h2>
          <p>
            With more neighborhood insights than any other real estate website,
            we've captured the color and diversity of communities.
          </p>
          <b-button>See Neighborhood</b-button>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: "home-component",
  data() {
    return {};
  },
  methods: {
    getImageURL(pic) {
      return require("../../assets/img/" + pic);
    },
  },
};
</script>
<style lang="scss" scoped>
.home-container {
  // position: ;
  text-align: center;
  color: white;
  max-width: 2000px;
  padding-right: 0px;
  padding-left: 0px;
  overflow: hidden;
  font-family: Georgia, serif;
  font-size: 100px;
  letter-spacing: 0.4px;
  word-spacing: 0.8px;
  color: #000000;
  font-weight: normal;
  text-decoration: none;
  font-style: normal;
  font-variant: normal;
  text-transform: none;
  text-shadow: 2px 2px 13px rgba(0, 0, 0, 0);
  color: #616161;
  // background: #bababa;
}

.get-started {
  display: flex;
  justify-content: center;
  margin-top: 10px;
  // padding: none;
}
.container-2 {
  position: absolute;
  top: 400px;
  left: 50%;
  transform: translate(-50%, -100%);
  color: black;
}
.image-1 {
  opacity: 0.8;
  margin-top: -100px;
  width: 100%;
}
.properties {
  position: absolute;
  margin-top: 90px;
  display: flex;
  justify-content: center;
}
.properties > img {
  width: 60%;
  border: solid 1px white;
  box-shadow: rgb(38, 57, 77) 0px 20px 30px -10px;
  margin: 10px;
}
.slogan {
  margin-top: 20px;
  color: black;
  font-family: sans-serif;
  font-weight: bolder;
}
.slogan-text {
  font-weight: bold;
}
// h3 {
//   margin-top: 20px;
// }
.description {
  color: #000000;
}
a {
  margin: 10px;
}
.bottom-cards {
  position: absolute;
  display: flex;
  justify-content: center;
  font-size: 15px;
  margin-top: 550px;
  padding-bottom: 100px;
  left: -120px;
}
.bottom-cards > div > img {
  width: 150px;
  height: 150px;
}

.bottom-card {
  box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;
  width: 300px;
  height: 400px;
  margin: 20px;
  padding: 20px;
  height: auto;
}

#app > div:nth-child(2) > div > div.image > img {
  margin-bottom: 550px;
}
.get-started-button {
  font-size: 25px;
  padding: 5px 30px;
  background: hsl(197, 100%, 68%);
  color: black;
}
button {
  background: hsl(197, 100%, 68%);
}
</style>