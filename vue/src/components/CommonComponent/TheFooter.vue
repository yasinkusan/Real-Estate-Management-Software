<template>
  <div>
    <div class="the-footer">
      <div class="nav-item">
        <section id="footer">
          <div class="container">
            <div
              class="row text-center text-xs-center text-sm-left text-md-left"
            ></div>
            <div class="row">
              <div class="col-xs-1 col-sm-1 col-md-12 mt-2 mt-sm-1">
                <ul class="list-unstyled list-inline social text-center">
                  <li class="list-inline-item">
                    <a href="https://www.facebook.com"
                      ><i class="fa fa-facebook"></i
                    ></a>
                  </li>
                  <li class="list-inline-item">
                    <a href="https://www.twitter.com"
                      ><i class="fa fa-twitter"></i
                    ></a>
                  </li>
                  <li class="list-inline-item">
                    <a href="https://www.instagram.com"
                      ><i class="fa fa-instagram"></i
                    ></a>
                  </li>
                  <li class="list-inline-item">
                    <a href="https://www.google.com"
                      ><i class="fa fa-google-plus"></i
                    ></a>
                  </li>
                </ul>
                <div
                  class="col-xs-12 col-sm-6 col-md-12 mt-2 mt-sm-2 text-center text-black"
                >
                  <p>
                    <u
                      ><a href="https://www.techelevator.com/"
                        >Halis, Yasin, Amy and Shareeque Capstone 2021, LLC</a
                      ></u
                    >
                    is Registered to Tech Elevator
                  </p>
                </div>
              </div>
            </div>
          </div>
        </section>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: "the-footer",
  data() {
    return {
      copyText: "Halis, Yasin, Amy and Shareeque Capstone 2021, LLC",
    };
  },
};
</script>

<style>
.the-footer {
  /* display: block; */
  background-color: hsl(197, 100%, 68%);
}

/* Footer */
@import url("https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css");
section {
  padding: 10px 0;
}

#footer {
  background: hsl(197, 100%, 68%) !important;
}

#footer a {
  color: black;
  text-decoration: none !important;
  background-color: transparent;
  -webkit-text-decoration-skip: objects;
}
#footer ul.social li {
  padding: 3px 0;
}
#footer ul.social li a i {
  margin-right: 5px;
  font-size: 25px;
  -moz-transition: 0.5s all ease;
  transition: 0.5s all ease;
}
#footer ul.social li:hover a i {
  font-size: 40px;
  margin-top: -10px;
}
#footer ul.social li a,
#footer ul.quick-links li a {
  color: black;
}
#footer ul.social li a:hover {
  color: black;
}
#footer ul.quick-links li {
  padding: 3px 0;
  -webkit-transition: 0.5s all ease;
  -moz-transition: 0.5s all ease;
  transition: 0.5s all ease;
}
#footer ul.quick-links li:hover {
  padding: 3px 0;
  margin-left: 5px;
  font-weight: 700;
}
#footer ul.quick-links li a i {
  margin-right: 5px;
}
#footer ul.quick-links li:hover a i {
  font-weight: 700;
}
@media (max-width: 767px) {
  #footer h5 {
    padding-left: 0;
    border-left: transparent;
    padding-bottom: 0px;
    margin-bottom: 10px;
  }
}
</style>
