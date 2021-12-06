import React, { Component } from 'react';
import NodeService from '../../services/NodeService';

class changeParent extends Component {

    state= {
        givenNodeId:'',
        targetNodeId:''
    }

    saveGivenNodeId=(e)=>{
        this.setState({givenNodeId:e.target.value})
    }

    saveTargetNodeId=(e)=>{
        this.setState({targetNodeId:e.target.value})
    }


    handleClick =()=>{
        const {givenNodeId, targetNodeId} = this.state;
        return NodeService.changeParent(givenNodeId,targetNodeId).then(({status,message})=> {
            if(status === 'Success') {
                alert('woohoo, parent changed successfully')
            } else {
                alert('pleae input correct data');
            }
        });
    };


    render() {
        return (
            <div>
                <p>------------------------------this is for git -----------------------------------------</p>
                <span>Change Parent Below</span>
                <form data-ts="Form">
                    <fieldset>
                        <label>
                            <span>Please input given node ID below</span>
                            <input onChange={this.saveGivenNodeId} placeholder="Given Node Id" type="text" />
                            <span>Please input target node Id below</span>
                            <input onChange={this.saveTargetNodeId} placeholder="Target Node Id" type="text" />
                        </label>
                    </fieldset>
                </form>
                <button data-ts="Button" class="ts-primary" onClick={this.handleClick}>change</button>
            </div>
        );
    }
}


export default changeParent;