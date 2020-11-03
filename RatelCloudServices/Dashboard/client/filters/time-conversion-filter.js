const moment = require('moment-timezone');
const timeconvert = (i, zt, fmt) => {
  if (zt == null) {
    zt = 'Australia/Melbourne';
  }
  if (fmt == null) {
    fmt = 'DD/MM/YYYY h:mm:ss a';
  }
  return moment(i).tz(zt).format(fmt);
}

export default timeconvert
