'use strict'
const proxy = require('http-proxy-middleware')
const merge = require('webpack-merge')
const prodEnv = require('./prod.env')

module.exports = merge(prodEnv, {
  NODE_ENV: '"local"'
})
