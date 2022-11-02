import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'main',
      component: () => import('@/components/main/main')
    },{
      path: '/a',
      name: 'a',
      component: HelloWorld
    }
    ,{
        path: '/test',
        name: 'test',
        component: () => import('@/components/test/test')
    }
    ,{
        path: '/test1',
        name: 'test1',
        component: () => import('@/components/test/test1')
    }
    ,{
        path: '/test2',
        name: 'test2',
        component: () => import('@/components/test/test2')
    }
    ,{
      path: '/download',
      name: 'download',
      component: () => import('@/components/test/testfiledown')
  }
    ,{
      path: '/testSock',
      name: 'testSock',
      component: () => import('@/components/test/testSock')
  }
  ,{
    path: '/overView',
    name: 'overView',
    component: () => import('@/components/profile/overView')
  }


  ],
  mode:"history"
})

