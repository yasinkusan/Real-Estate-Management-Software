<template>
  <div>
    <h2 class="Welcome">Welcome {{ this.$store.state.user.username }}</h2>
    <div class="accordion" role="tablist">
      <b-card no-body class="mb-1">
        <b-card-header header-tag="header" class="p-1" role="tab">
          <b-button block v-b-toggle.accordion-1 variant="info">
            <span class="when-open">Close</span
            ><span class="when-closed">Open</span> Notifications
          </b-button>
        </b-card-header>
        <b-collapse
          id="accordion-1"
          visible
          accordion="my-accordion"
          role="tabpanel"
        >
          <pending-requests-table />
          <div class="spacing"></div>
          <pending-applications-table />
        </b-collapse>
      </b-card>

      <b-card no-body class="mb-1">
        <b-card-header header-tag="header" class="p-1" role="tab">
          <b-button block v-b-toggle.accordion-2 variant="info">
            <span class="when-open">Close</span
            ><span class="when-closed">Open</span> Property Management
          </b-button>
        </b-card-header>
        <b-collapse id="accordion-2" accordion="my-accordion" role="tabpanel">
          <manage-properties />
        </b-collapse>
      </b-card>

      <b-card no-body class="mb-1">
        <b-card-header header-tag="header" class="p-1" role="tab">
          <b-button block v-b-toggle.accordion-3 variant="info">
            <span class="when-open">Close</span
            ><span class="when-closed">Open</span> Payment History
          </b-button>
        </b-card-header>
        <b-collapse id="accordion-3" accordion="my-accordion" role="tabpanel">
          <admin-payment-history />
        </b-collapse>
      </b-card>
      <b-card no-body class="mb-1">
        <b-card-header header-tag="header" class="p-1" role="tab">
          <b-button block v-b-toggle.accordion-4 variant="info">
            <span class="when-open">Close</span
            ><span class="when-closed">Open</span> Applications
          </b-button>
        </b-card-header>
        <b-collapse id="accordion-4" accordion="my-accordion" role="tabpanel">
          <application-history />
        </b-collapse>
      </b-card>
    </div>
  </div>
</template>

<script>
import PendingRequestsTable from "./PendingRequestsTable.vue";
import AdminPaymentHistory from "./AdminPaymentHistory.vue";
import PendingApplicationsTable from "./PendingApplicationsTable.vue";
import ApplicationHistory from "./ApplicationHistory.vue";
import ManageProperties from "./ManageProperties.vue";
export default {
  components: {
    PendingRequestsTable,
    AdminPaymentHistory,
    PendingApplicationsTable,
    ApplicationHistory,
    ManageProperties,
  },
  name: "dashboard-component",
  data() {
    return {
      text: "nice",
    };
  },
};
</script>

<style scoped>
.edit-button {
  margin: 10px;
}
.spacing {
  height: 20px;
}
.collapsed > .when-open,
.not-collapsed > .when-closed {
  display: none;
}
.Welcome {
  display: flex;
  justify-content: center;
  margin-top: 20px;
  margin-bottom: 30px;
}
#app
  > div:nth-child(2)
  > div:nth-child(2)
  > div
  > div:nth-child(1)
  > header
  > button {
  font-size: 20px;
}

#app
  > div:nth-child(2)
  > div:nth-child(2)
  > div
  > div:nth-child(2)
  > header
  > button {
  font-size: 20px;
}
#app
  > div:nth-child(2)
  > div:nth-child(2)
  > div
  > div:nth-child(3)
  > header
  > button {
  font-size: 20px;
}
#app
  > div:nth-child(2)
  > div:nth-child(2)
  > div
  > div:nth-child(4)
  > header
  > button {
  font-size: 20px;
}
#app > div:nth-child(2) > div:nth-child(2) {
  margin-bottom: 500px;
}
</style>