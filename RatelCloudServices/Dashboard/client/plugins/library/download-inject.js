const download = require("downloadjs");
export default ({ app }, inject) => {
  inject('download',download)
}
