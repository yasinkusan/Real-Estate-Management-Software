<template>
  <div>
    <div class="main">
      <div>
        <div class="portfolio">
          <b-card
            :title="'Amy Winkler'"
            tag="article"
            style="width: 20rem"
            class="mb-2"
          >
            <img :src="getImageURL('Amy.jpg')" class="image" />
            <b-card-text> CEO </b-card-text>
          </b-card>
          <b-card
            :title="'Halis Yigin'"
            tag="article"
            style="width: 20rem"
            class="mb-2"
          >
            <img :src="getImageURL('Halis.jpg')" class="image" />
            <b-card-text> CEO </b-card-text>
          </b-card>
          <b-card
            :title="'Shareeque Sadiq'"
            tag="article"
            style="width: 20rem"
            class="mb-2"
          >
            <img :src="getImageURL('SADIQ.jpg')" class="image" />
            <b-card-text> CEO </b-card-text>
          </b-card>
          <b-card
            :title="'Yasin Kusan'"
            tag="article"
            style="width: 20rem"
            class="mb-2"
          >
            <img :src="getImageURL('Yasin.jpg')" class="image" />
            <b-card-text> CEO </b-card-text>
          </b-card>
        </div>
        <h1>About us</h1>
        <p>
          Dwellings.com is reimagining real estate to make it easier to unlock
          life’s next chapter. We hope to become the most-visited real estate
          website in the United States. We offer customers an on-demand
          experience for renting and financing with transparency and nearly
          seamless end-to-end service.
        </p>
      </div>
      <h1>Our Mission</h1>
      <p>
        We believe that everyone should have access to a great new home. With
        that in mind we created Dwellings.com so we can give everyone the chance
        as a beautiful dwelling.
      </p>
      <h1>Our Vision</h1>
      <p>
        Our vision is to be the leading real estate service provider in the
        United States. We consistently strive to develop collaborative
        partnerships, based on transparency and mutual trust, which serve to
        build enduring client relationships. As we expand, we’re committed to
        these principles, which have served our company and clients through the
        years.
      </p>
      <li>1st – Our clients</li>
      <li>2nd – Our Company as a whole</li>
      <li>3rd – Individual team members</li>
    </div>
  </div>
</template>

<script>
export default {
  name: "about-component",
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

<style scoped>
#app > div:nth-child(2) > div > div > div > article > div > img {
  width: 100px;
  height: 100px;
}

.main {
  font-family: Georgia, serif;
  font-size: 20px;
  letter-spacing: -1px;
  word-spacing: 1px;
  color: #000000;
  font-weight: normal;
  text-decoration: none;
  font-style: normal;
  font-variant: normal;
  text-transform: none;
  margin: 5% 30%;
}
.portfolio {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;

  width: 700px;
}
#app > div:nth-child(2) > div > div > div > article > div {
  width: 210px;
  padding-left: 30px;
  box-shadow: rgba(0, 0, 0, 0.19) 0px 10px 20px, rgba(0, 0, 0, 0.23) 0px 6px 6px;
}
#app > div:nth-child(2) > div > div > div > article > div > img {
  margin-left: 20px;
}
#app > div:nth-child(2) > div > div > div > article > div > p {
  margin-left: 50px;
}
#app > div:nth-child(2) > div > div > div > article:nth-child(2) > div > h4 {
  padding-left: 15px;
}
</style>