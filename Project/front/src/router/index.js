import Vue from 'vue'
import Router from 'vue-router'

import test_router from './test_router'


Vue.use(Router)


export default new Router({

  routes: [
    ...test_router,
    {
      path: '/',
      name: 'main',
      component: () => import('@/components/main/main')
    }
    , {
      path: '/pagenotfound',
      name: 'pagenotfound',
      component: () => import( '@/components/main/pagenotfound')

    }, {
      path: '/login',
      name: 'login',
      component: () => import( '@/components/login/login')
    }
    ,{
      path: '/create',
      name: 'create',
      component: () => import('@/components/repository/create')
    }   
    , {
      path: '/:nick',
      name: 'profile',
      component: () => import( '@/components/profile/profile')

    }
    
    
   
  ],
  mode:"history"
})

