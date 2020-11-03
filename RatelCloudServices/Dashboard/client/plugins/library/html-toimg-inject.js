const htmlToImage = require('html-to-image');
export default ({ app }, inject) => {
  inject('htmlToImage',htmlToImage)
}
