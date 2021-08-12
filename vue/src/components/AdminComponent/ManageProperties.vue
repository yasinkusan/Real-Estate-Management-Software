<template>
  <div>
    <!-- <b-button class="edit-button" variant="primary">ADD a Property</b-button> -->
    <div class="container">
      <div class="row">
        <div class="col-md-offset-1 col-md-10">
          <div class="panel">
            <div class="panel-heading">
              <div class="row">
                <div class="col col-sm-3 col-xs-12">
                  <h4 class="title">Property <span>List</span></h4>
                </div>

                <div class="col-sm-9 col-xs-12 text-right">
                  <div class="btn_group">
                    <router-link
                      :to="{
                        name: 'add-a-property',
                      }"
                    >
                      <b-button class="edit-button" variant="primary"
                        >ADD a Property</b-button
                      ></router-link
                    >
                    <input
                      type="text"
                      class="form-control"
                      placeholder="Search"
                    />
                  </div>
                </div>
              </div>
            </div>

            <div class="panel-body table-responsive">
              <table class="table">
                <thead>
                  <tr>
                    <th>Address</th>
                    <th>Rent amount</th>
                    <th>Action</th>
                  </tr>
                </thead>

                <tbody
                  v-for="property in properties"
                  :key="property.propertyId"
                >
                  <tr>
                    <td>
                      {{ property.address.addressLine }},
                      {{ property.address.city }}, {{ property.address.state }},
                      {{ property.address.zipCode }}
                    </td>
                    <td>${{ property.rentAmount }}</td>
                    <td>
                      <ul class="action-list">
                        <li>
                          <b-button variant="primary">EDIT</b-button>
                        </li>
                        <li>
                          <b-button
                            variant="danger"
                            v-on:click="remove(property.propertyId)"
                            >REMOVE</b-button
                          >
                        </li>
                      </ul>
                    </td>

                    <!-- <b-button class="edit-button" variant="primary"
              >ADD a Property</b-button
            >
            <b-button class="edit-button" variant="danger"
              >DELETE a Property</b-button
            >
            <b-button class="edit-button" variant="secondary"
              >EDIT a property</b-button
            > -->
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import propertyService from "../../services/PropertyService";
export default {
  data() {
    return {
      properties: [],
    };
  },

  created() {
    propertyService
      .retrievePropertiesByUserId(this.$store.state.user.id)
      .then((response) => {
        this.properties = response.data;
      })
      .catch((error) => {
        this.handleErrorResponse(error);
      });
  },
  methods: {
    remove(propertyId) {
      propertyService.removeProperty(propertyId);
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
#accordion-2
  > div
  > div
  > div
  > div
  > div
  > div.panel-heading
  > div
  > div.col-sm-9.col-xs-12.text-right
  > div
  > button {
  margin-right: 5px;
  margin-bottom: 3px;
  color: white;
}
.demo {
  font-family: "Noto Sans", sans-serif;
}
.panel {
  background: linear-gradient(to right, #2980b9, #2c3e50);
  padding: 0;
  border-radius: 10px;
  border: none;
  box-shadow: 0 0 0 5px rgba(0, 0, 0, 0.05), 0 0 0 10px rgba(0, 0, 0, 0.05);
}
.panel .panel-heading {
  padding: 20px 15px;
  border-radius: 10px 10px 0 0;
  margin: 0;
}
.panel .panel-heading .title {
  color: #fff;
  font-size: 28px;
  font-weight: 500;
  width: 500px;
  text-transform: capitalize;
  line-height: 40px;
  margin: 0;
}
.panel .panel-heading .btn {
  color: white;
  /* background: transparent; */
  font-size: 16px;
  text-transform: capitalize;
  border: 2px solid #fff;
  border-radius: 50px;
  transition: all 0.3s ease 0s;
}
.panel .panel-heading .btn:hover {
  color: #fff;
  text-shadow: 3px 3px rgba(255, 255, 255, 0.2);
}
.panel .panel-heading .form-control {
  color: #fff;
  background-color: transparent;
  width: 35%;
  height: 40px;
  border: 2px solid #fff;
  border-radius: 20px;
  display: inline-block;
  transition: all 0.3s ease 0s;
}
.panel .panel-heading .form-control:focus {
  background-color: rgba(255, 255, 255, 0.2);
  box-shadow: none;
  outline: none;
}
.panel .panel-heading .form-control::placeholder {
  color: rgba(255, 255, 255, 0.5);
  font-size: 15px;
  font-weight: 500;
}
.panel .panel-body {
  padding: 0;
}
.panel .panel-body .table thead tr th {
  color: #fff;
  background-color: rgba(255, 255, 255, 0.2);
  font-size: 16px;
  font-weight: 500;
  text-transform: uppercase;
  padding: 12px;
  border: none;
}
.panel .panel-body .table tbody tr td {
  color: #fff;
  font-size: 15px;
  padding: 10px 12px;
  vertical-align: middle;
  border: none;
}
.panel .panel-body .table tbody tr:nth-child(even) {
  background-color: rgba(255, 255, 255, 0.05);
}
.panel .panel-body .table tbody .action-list {
  padding: 0;
  margin: 0;
  list-style: none;
}
.panel .panel-body .table tbody .action-list li {
  display: inline-block;
  margin: 0 5px;
}
.panel .panel-body .table tbody .action-list li a {
  color: #fff;
  font-size: 15px;
  position: relative;
  z-index: 1;
  transition: all 0.3s ease 0s;
}
.panel .panel-body .table tbody .action-list li a:hover {
  text-shadow: 3px 3px 0 rgba(255, 255, 255, 0.3);
}
.panel .panel-body .table tbody .action-list li a:before,
.panel .panel-body .table tbody .action-list li a:after {
  content: attr(data-tip);
  color: #fff;
  background-color: #111;
  font-size: 12px;
  padding: 5px 7px;
  border-radius: 4px;
  text-transform: capitalize;
  display: none;
  transform: translateX(-50%);
  position: absolute;
  left: 50%;
  top: -32px;
  transition: all 0.3s ease 0s;
}
.panel .panel-body .table tbody .action-list li a:after {
  content: "";
  height: 15px;
  width: 15px;
  padding: 0;
  border-radius: 0;
  transform: translateX(-50%) rotate(45deg);
  top: -18px;
  z-index: -1;
}
.panel .panel-body .table tbody .action-list li a:hover:before,
.panel .panel-body .table tbody .action-list li a:hover:after {
  display: block;
}
.panel .panel-footer {
  color: #fff;
  background-color: transparent;
  padding: 15px;
  border: none;
}
.panel .panel-footer .col {
  line-height: 35px;
}
.pagination {
  margin: 0;
}
.pagination li a {
  color: #fff;
  background-color: transparent;
  border: 2px solid transparent;
  font-size: 18px;
  font-weight: 500;
  text-align: center;
  line-height: 31px;
  width: 35px;
  height: 35px;
  padding: 0;
  margin: 0 3px;
  border-radius: 50px;
  transition: all 0.3s ease 0s;
}
.pagination li a:hover {
  color: #fff;
  background-color: transparent;
  border-color: rgba(255, 255, 255, 0.2);
}
.pagination li a:focus,
.pagination li.active a,
.pagination li.active a:hover {
  color: #fff;
  background-color: transparent;
  border-color: #fff;
}
.pagination li:first-child a,
.pagination li:last-child a {
  border-radius: 50%;
}

@media only screen and (max-width: 767px) {
  .panel .panel-heading .title {
    text-align: center;
    margin: 0 0 10px;
  }
  .panel .panel-heading .btn_group {
    text-align: center;
  }
}
.row {
  display: flex;
  justify-content: center;
}
.edit-button {
  background: #007bff !important;
  margin-bottom: 4px;
  margin-right: 20px;
  color: white;
}
</style>