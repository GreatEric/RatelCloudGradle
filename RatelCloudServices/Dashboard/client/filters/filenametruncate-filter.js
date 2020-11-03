const filenametruncate = (str, length, mask) => {
  if (length == null) {
    length = 20;
  }
  if (mask == null) {
    mask = '***';
  }
  if (str.length > length) {
    let start = str.substring(0, 3);
    let end = str.substring(str.lastIndexOf('.'),str.length);
    return start + mask + end;
  } else {
    return str;
  }
}

export default filenametruncate
