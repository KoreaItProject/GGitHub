import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },{
      path: '/a',
      name: 'a',
      component: HelloWorld
    }
    ,{
        path: '/test',
        name: 'test',
        component: () => import('@/views/test/test')
    }
    ,{
        path: '/test1',
        name: 'test1',
        component: () => import('@/views/test/test1')
    }
    ,{
        path: '/test2',
        name: 'test2',
        component: () => import('@/views/test/test2')
    }
    ,{
      path: '/download',
      name: 'download',
      component: () => import('@/views/test/testfiledown')
  }

  ],
  mode:"history"
})

