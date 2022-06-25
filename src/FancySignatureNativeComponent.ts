// @ts-ignore
import type { ViewProps } from "react-native/Libraries/Components/View/ViewPropTypes";
import type { HostComponent } from "react-native";
// @ts-ignore
import codegenNativeComponent from "react-native/Libraries/Utilities/codegenNativeComponent";
// @ts-ignore
import codegenNativeCommands from "react-native/Libraries/Utilities/codegenNativeCommands";
import React from "react";

interface NativeProps extends ViewProps {
  penColor: string;
}

type ComponentType = HostComponent<NativeProps>;

interface NativeCommands {
  clear: (signatureRef: React.ElementRef<ComponentType>) => void;
}

export const Commands: NativeCommands = codegenNativeCommands<NativeCommands>({
  supportedCommands: ["clear"],
});

export default codegenNativeComponent<NativeProps>(
  "FancySignature"
) as HostComponent<NativeProps>;
