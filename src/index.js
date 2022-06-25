// @flow
import React from "react";
import {
  requireNativeComponent,
  UIManager,
  findNodeHandle,
} from "react-native";

const isFabricEnabled = global.nativeFabricUIManager != null;
let FancySignature;
let Commands;
if (isFabricEnabled) {
  const module = require("./FancySignatureNativeComponent");
  FancySignature = module.default;
  Commands = module.Commands;
} else {
  FancySignature = requireNativeComponent("FancySignature");
}

export default React.forwardRef((props, ref) => {
  const nativeComponent = React.useRef();

  React.useImperativeHandle(
    ref,
    () => ({
      clear() {
        if (isFabricEnabled) {
          Commands.clear(nativeComponent.current);
        } else {
          UIManager.dispatchViewManagerCommand(
            findNodeHandle(nativeComponent.current),
            1,
            []
          );
        }
      },
    }),
    [Commands, isFabricEnabled]
  );

  return <FancySignature ref={nativeComponent} {...props} />;
});
