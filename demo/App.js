import React, {useState, useRef} from 'react';
import {Text, SafeAreaView, View, Pressable} from 'react-native';
import FancySignature from 'react-native-fancy-signature/src/index';

const COLORS = {
  Black: '#000000',
  Red: '#FF0000',
  Green: '#00FF00',
  Blue: '#0000FF',
};

const Buttons = ({setColor}) => {
  return Object.keys(COLORS).map(v => {
    return (
      <Pressable
        key={v}
        onPress={() => {
          setColor(COLORS[v]);
        }}
        style={{
          paddingVertical: 4,
          paddingHorizontal: 10,
          backgroundColor: COLORS[v],
          borderRadius: 4,
        }}>
        <Text style={{color: 'white'}}>{v}</Text>
      </Pressable>
    );
  });
};

const App = () => {
  const [color, setColor] = useState(COLORS.Black);
  const signatureRef = useRef(null);
  return (
    <SafeAreaView style={{flex: 1, backgroundColor: 'white'}}>
      <View style={{display: 'flex', flexDirection: 'row'}}>
        <Text style={{color: 'black'}}>FancySignature Demo</Text>
        <Text style={{color: 'black'}}>
          {global.nativeFabricUIManager ? '[FABRIC]' : '[PAPAER]'}
        </Text>
      </View>
      <View
        style={{
          flexDirection: 'row',
          justifyContent: 'space-between',
          paddingHorizontal: 10,
        }}>
        <Buttons setColor={setColor} />
      </View>
      <Pressable
        onPress={() => {
          try {
            console.log('PRESSED');
            signatureRef.current.clear();
          } catch (err) {
            console.log(err);
          }
        }}
        style={{backgroundColor: 'red'}}>
        <Text>Clear</Text>
      </Pressable>
      <View style={{flex: 1, backgroundColor: 'pink'}}>
        <FancySignature ref={signatureRef} style={{flex: 1}} penColor={color} />
      </View>
    </SafeAreaView>
  );
};

export default App;
