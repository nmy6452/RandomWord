import React, {useEffect, useState} from 'react';
import axios from 'axios';

function Home() {
    const [hello, setHello] = useState('')
    const [randowmWord, setRandowmWord] = useState("");
 
     useEffect(() => {
         axios.get('/api/hello')
         .then(response => setHello(response.data))
         .catch(error => console.log(error))
     }, []);
 
     function get_word(){
       axios.get('api/word')
       .then(response => {
         console.log(response.data)
         setRandowmWord(response.data.word)
       })
       .catch(error => console.log(error));
     }

    return (
    <div className="Home">
        <p>
            안녕: {hello}
            렌덤한 단어: {randowmWord}
        </p>
        <button onClick={get_word}>출력</button>
    </div>
    );
}
export default Home;