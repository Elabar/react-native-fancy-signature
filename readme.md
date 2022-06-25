# react-native-fancy-signature

> **Warning**
> This project is currently under development!

## Usage
```
import FancySignature from 'react-native-fancy-signature/src/index'

const App = () => {
    const signatureRef = useRef(null)

    const clearPad = () => {
        signatureRef.current.clear()
    }

    return (
        <View style={{flex: 1}}>
            <FancySignature
                ref={signatureRef}
                penColor="#FF00FF"
                style={{flex: 1}}
            >
        </View>
    )
}

```

## Insights
Under the hood, it uses `com.github.gcacace:signature-pad:1.3.1` for Android, and `TBD` for iOS.

## Roadmap
- [x] Android Paper
- [ ] Android Fabric
- [ ] iOS Paper
- [ ] iOS Fabric

## Development
We are using npm to run this project. Run the following command to pack the project. This will generate a tar so we can install it with npm without creating symlink
```
npm run pre-pack
```

Once the tar is generated, go into demo folder, install and run react-native
```
cd demo
npm install ../react-native-fancy-signature-0.0.1.tgz
npx react-native run-android
```