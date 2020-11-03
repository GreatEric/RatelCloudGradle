import menus from '../commons/menus';
import recursive from '../commons/recursive';

export default function({ store, app }) {
  /*app.router.beforeEach((to, from, next) => {

    /!*console.log("当前路由-path:",this.$nuxt.$route.path)
    console.log("当前路由-name:",this.$nuxt.$route.path)
    console.log("当前zone:",this.$nuxt.$route.query.zone);*!/

    let info={
      from: from,
      to: to,
      next: next
    }
    store.commit('routing/route',info);

    console.log("路由信息:",store.state.routing.routing);

    next()
  })*/

  /*app.router.afterEach((to, from) => {
    let info={
      from: from,
      to: to
    }
    store.commit('routing/route',info);

    console.log("路由信息:",store.state.routing.routing);
  })*/

  //console.log(app.router.history.current.path);

  let node = recursive(menus,'path',app.router.history.current.path);
  let info={
    from: node,
    current: {}
  }

  store.commit('routing/route',info);
  //console.log("历史路由信息:",store.state.routing.routing);
}
