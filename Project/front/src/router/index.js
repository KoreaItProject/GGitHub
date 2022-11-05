import Vue from 'vue'
import Router from 'vue-router'
import testRouter from './testRouter'

Vue.use(Router)


export default new Router({

  routes: [
    ...testRouter,
    {
      path: '/',
      name: 'main',
      component: () => import('@/components/main/main')
    }
    , {
      path: '/pagenotfound',
      name: 'pagenotfound',
      component: () => import( '@/components/main/pagenotfound')

    }
    , {
      path: '/:nick',
      name: 'profile',
      component: () => import( '@/components/profile/profile')

    }
    
  ],
  mode:"history"
})

