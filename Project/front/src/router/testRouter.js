


export default({
  routes: [

    {
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

 


  ],
  mode:"history"
})

