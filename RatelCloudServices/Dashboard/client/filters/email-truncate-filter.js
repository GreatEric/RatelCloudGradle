const emailtruncate = (str, length, mask) => {
  if (length == null) {
    length = 15;
  }
  if (mask == null) {
    mask = '***';
  }
  if (str.length > length) {
    let start = str.substring(0, 5);
    let end = str.substring(str.length -3 ,str.length);
    return start + mask + end;
  } else {
    return str;
  }
}

export default emailtruncate
