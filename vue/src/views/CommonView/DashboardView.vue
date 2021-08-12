<template>
  <div>
    <dashboard-component
      v-show="
        this.$store.state.user.authorities[0].name == 'ROLE_USER' ? true : false
      "
    />
    <admin-dashboard
      v-show="
        this.$store.state.user.authorities[0].name == 'ROLE_ADMIN'
          ? true
          : false
      "
    />
  </div>
</template>

<script>
import AdminDashboard from "../../components/AdminComponent/AdminDashboard.vue";
import DashboardComponent from "../../components/UserComponent/DashboardComponent";
export default {
  name: "dashboard-view",
  components: { DashboardComponent, AdminDashboard },
};
</script>

<style scoped>
</style>