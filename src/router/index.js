import { createRouter, createWebHistory } from "vue-router";
import Home from "../views/Home.vue";
// import IFT2015 from "../views/IFT2015.vue";
// import IFT2035 from "../views/IFT2035.vue";
// import IFT2105 from "../views/IFT2105.vue";
// import IFT2255 from "../views/IFT2255.vue";

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/IFT2015",
    name: "IFT2015",
    // component: IFT2015,
    // route level code-splitting
    // this generates a separate chunk (IFT2015.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "IFT2015" */ "../views/IFT2015.vue"),
  },
  {
    path: "/IFT2035",
    name: "IFT2035",
    // component: IFT2035,
    // route level code-splitting
    // this generates a separate chunk (IFT2035.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "IFT2035" */ "../views/IFT2035.vue"),
  },
  {
    path: "/IFT2105",
    name: "IFT2105",
    // component: IFT2105,
    // route level code-splitting
    // this generates a separate chunk (IFT2105.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "IFT2105" */ "../views/IFT2105.vue"),
  },
  {
    path: "/IFT2255",
    name: "IFT2255",
    // component: IFT2255,
    // route level code-splitting
    // this generates a separate chunk (IFT2255.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "IFT2255" */ "../views/IFT2255.vue"),
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
