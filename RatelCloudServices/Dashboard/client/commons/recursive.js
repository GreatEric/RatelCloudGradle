const recursive = (list, key , value) => {
  if (!list) {
    return;
  }

  if(!key){
    return;
  }

  if(!value){
    return;
  }

  let result = null;
  const find = (list)=>{
    for( let i=0; i< list.length; i++){
      let node = list[i];
      if(node[key] === value){
        result = node;
        break;
      }else{
        if( node.children && node.children.length > 0 )
          find(node.children)
      }
    }
  }

  find(list);
  return result;
}
export default recursive
