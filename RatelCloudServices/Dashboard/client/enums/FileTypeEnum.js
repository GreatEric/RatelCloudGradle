import Enum from "./Enum";

const FileTypeEnum = new Enum()
  .add('IMAGE', 'image', 1)
  .add('FILE', 'file', 2)
  .add('VIDEO', 'video', 3);

export default FileTypeEnum;
