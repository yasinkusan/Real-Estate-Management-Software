import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/CommonView/Home.vue'
import Login from '../views/CommonView/Login.vue'
import Logout from '../views/CommonView/Logout.vue'
import Register from '../views/CommonView/Register.vue'
import PropertyListView from '../views/CommonView/PropertyListView.vue'
import AddAProperty from '../views/AdminView/AddAProperty'
import PropertyDetail from '../views/CommonView/PropertyDetail'
import ApplyPropertyForm from '../views/UserView/ApplyPropertyForm'
import DashboardView from '../views/CommonView/DashboardView'
import PaymentView from '../views/UserView/PaymentView'
import store from '../store/index'
import AboutView from '../views/CommonView/AboutView'
import ContactUsView from '../views/CommonView/ContactUsView'
import MaintenanceReqForm from '../views/UserView/MaintenanceReqForm'

Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: '/addProperty',
      name: 'add-a-property',
      component: AddAProperty,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/properties",
      name: "property-list-view",
      component: PropertyListView,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/detail/:propertyId",
      name: "property-detail",
      component: PropertyDetail,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/application/:propertyId",
      name: "apply-property-form",
      component: ApplyPropertyForm,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/dashboard",
      name: "dashboard-view",
      component: DashboardView,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/payment/:propertyId",
      name: "payment-view",
      component: PaymentView,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/maintenance",
      name: "maintenance-request-form",
      component: MaintenanceReqForm,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/about",
      name: "about-view",
      component: AboutView,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/contactus",
      name: "contact-us-view",
      component: ContactUsView,
      meta: {
        requiresAuth: false
      }
    },
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
