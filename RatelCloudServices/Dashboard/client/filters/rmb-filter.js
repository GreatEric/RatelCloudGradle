const rmb = (val, str, hasSymbol) => {
  if (str > 0 && typeof hasSymbol === 'undefined' ) {
    return `¥ ${val}.00`;
  } else if (str > 0 && !hasSymbol) {
    return `${val}.00`;
  } else {
    return `¥ ${val}`;
  }
}
export default rmb
