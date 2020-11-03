const booleanconvert = (i,opposite,yes,no) => {
  if(opposite){
    if(i===true){
      if(no!=null){
        return no
      }else{
        return "Unavailable"
      }
    }else{
      if(yes!=null){
        return yes
      }else{
        return "Available"
      }
    }
  }else{
    if(i===true){
      if(yes!=null){
        return yes
      }else{
        return "Available"
      }
    }else{
      if(no!=null){
        return no
      }else{
        return "Unavailable"
      }
    }
  }
}

export default booleanconvert
