import React, { Component } from 'react';
import NodeService from '../../services/NodeService';
import './FindDescendants.css';
import tree from './nodetree.png';

class FindDescendants extends Component {
    
    state= {
        showData: [],
        givenNodeId:''
    }

    saveGivenNodeId=(e)=>{
        this.setState({givenNodeId:e.target.value})
    }

    handleClick =()=>{
        return NodeService.getDescendantNodesId(this.state.givenNodeId).then(({status,message})=> {
            if(status === 'Success') {
                this.setState({showData: message});
            } else {
                alert('pleae input correct data');
            }
        });
    };


    render() {
        const {showData} = this.state;
        return (
            <div>
                <img className="photo" src={tree}/>
                <form data-ts="Form">
                    <fieldset>
                        <label>
                            <span>Please input given node ID below</span>
                            <input className="smaller-input" onChange={this.saveGivenNodeId} placeholder="Given Node Id" type="text" required/>
                        </label>
                        <dl class="ts-info">
                            <dt>Text Info</dt>
                            <dd>This field is required</dd>
                            <dd>Please input numbers from 0 to 5</dd>
                        </dl>
                    </fieldset>
                </form>
                <button data-ts="Button" class="ts-primary" onClick={this.handleClick}>click to show all descendant nodes</button>
                <br/>
                <ul>     
                    {showData.map((e)=><li >                                      
                                             <i class="ts-icon-rating"></i>
                                             node Id:{e.id}<br/>
                                             node value:{e.val}<br/>
                                             node parent Id:{e.parentId}<br/>
                                             node height:{e.height}<br/>                                    
                                      </li>)}
                </ul>
            </div>
        );
    }
}


export default FindDescendants;