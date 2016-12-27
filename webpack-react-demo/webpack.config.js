var path = require('path');
//在开发环境中使用压缩文件
//1.每当 "react" 在代码中被引入，它会使用压缩后的 React JS 文件，而不是到 node_modules 中找。
//2.每当 Webpack 尝试去解析那个压缩后的文件，我们阻止它，因为这不必要。
var node_modules = path.resolve(__dirname,'node_modules');
var pathToReact = path.resolve(node_modules,'react/dist/react.min.js'); //为了不让 Webpack 去遍历 React JS 及其所有依赖，你可以在开发中重写它的行为
var config = {
  entry: [
    'webpack/hot/dev-server',
    'webpack-dev-server/client?http://localhost:8080', //这两行是设置自动刷新
    path.resolve(__dirname, 'app/main.js')
  ],
  resolve: {
    alias: {
      'react': pathToReact
    }
  },
  output: {
    path: path.resolve(__dirname, 'build'),
    filename: 'bundle.js'
  },
  module: {
    loaders: [{
      test: /\.js$/,
      loaders: ['react-hot', 'babel']
      },{
      test: /\.jsx?$/, // 用正则来匹配文件路径，这段意思是匹配 js 或者 jsx
      loader: 'babel', // 加载模块 "babel" 是 "babel-loader" 的缩写
      query: {
        presets: ['react']
      }
    }, {
      test: /\.css$/, // Only .css files
      loader: 'style!css' // Run both loaders
    }],
    noParse: [pathToReact]
  }
};

module.exports = config;
